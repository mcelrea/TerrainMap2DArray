public class Main {
    public static void main(String[] args) {
        int[][] data = {{9, 9, 9, 9, 9, 9},
                        {9, 2, 2, 2, 2, 9},
                        {9,-1,-1, 0, 5, 9},
                        {9, 7,-3,-1, 6, 9},
                        {10,8, 9, 9, 8, 9},
                        {10,11,11,11,10,10}};
        TerrainData t = new TerrainData(data);
        System.out.println(t.countSquaresBelowSeaLevel());
        System.out.println(t.getShearDrops());
    }
}