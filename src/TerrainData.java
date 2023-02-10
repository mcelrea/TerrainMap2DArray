import java.util.ArrayList;

public class TerrainData {
    private int[][] terrainData;

    public TerrainData(int[][] a) {
        terrainData = a;
    }

    public int countSquaresBelowSeaLevel() {
        int counter = 0;
        for(int i=0; i < terrainData.length; i++) {
            for(int j=0; j < terrainData[i].length; j++) {
                if(terrainData[i][j] < 0)
                    counter++;
            }
        }
        return counter;
    }

    private boolean isLocValid(Location loc) {
        if(loc == null)
            return false;

        return loc.getRow() >= 0 && loc.getCol() >= 0 &&
                loc.getRow() < terrainData.length &&
                loc.getCol() < terrainData[0].length;
    }

    public boolean isShearDrop(int row, int col) {

        //check if the location above me is valid
        if (isLocValid(new Location(row-1,col))) {
            int dif = terrainData[row][col] - terrainData[row-1][col];
            if (dif >= 5)
                return true;
        }
        //check if the location below me is valid
        if (isLocValid(new Location(row+1,col))) {
            int dif = terrainData[row][col] - terrainData[row+1][col];
            if (dif >= 5)
                return true;
        }
        //check if the location left me is valid
        if (isLocValid(new Location(row,col-1))) {
            int dif = terrainData[row][col] - terrainData[row][col-1];
            if (dif >= 5)
                return true;
        }
        //check if the location left me is valid
        if (isLocValid(new Location(row,col+1))) {
            int dif = terrainData[row][col] - terrainData[row][col+1];
            if (dif >= 5)
                return true;
        }

        return false; //there were no shear drops
    }

    public ArrayList<Location> getShearDrops() {
        ArrayList<Location> locs = new ArrayList<>();

        for(int i=0; i < terrainData.length; i++) {
            for (int j = 0; j < terrainData[i].length; j++) {
                if(isShearDrop(i,j)) {
                    locs.add(new Location(i,j));
                }
            }
        }

        return locs;
    }
}
