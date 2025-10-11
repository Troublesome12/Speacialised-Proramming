public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int minPos = Integer.MAX_VALUE;
        int maxPos = Integer.MIN_VALUE;

        for (int c : coordinates) {
            minPos = Math.min(minPos, c + X);
            maxPos = Math.max(maxPos, c - X);
        }

        return Math.max(0, minPos - maxPos);
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
