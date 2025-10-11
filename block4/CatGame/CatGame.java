public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int c : coordinates) {
            min = Math.min(min, c);
            max = Math.max(max, c);
        }

        return Math.max(0, (max - min) - 2 * X);
    }

    public static void main(String[] args) {
        CatGame cg = new CatGame();
        System.out.println(cg.getNumber(new int[]{-3, 0, 1}, 3)); 
        System.out.println(cg.getNumber(new int[]{4, 7, -7}, 5));
        System.out.println(cg.getNumber(new int[]{-100000000, 100000000}, 100000000)); 
        System.out.println(cg.getNumber(new int[]{3,7,4,6,-10,7,10,9,-5},7));
        System.out.println(cg.getNumber(new int[]{-4, 0, 4, 0},4));
        System.out.println(cg.getNumber(new int[]{7},0));
    }
}
