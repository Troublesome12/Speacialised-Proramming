public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int result = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << coordinates.length); mask++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < coordinates.length; i++) {
                int pos = ((mask & (1 << i)) == 0)
                        ? coordinates[i] - X
                        : coordinates[i] + X;
                min = Math.min(min, pos);
                max = Math.max(max, pos);
            }
            result = Math.min(result, max - min);
        }
        return result;
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
