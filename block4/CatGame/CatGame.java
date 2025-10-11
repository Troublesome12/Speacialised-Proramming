public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;

        for (int c : coordinates) {
            maxLeft = Math.max(maxLeft, c - X);
            minRight = Math.min(minRight, c + X);
        }

        return Math.max(0, maxLeft - minRight);
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
