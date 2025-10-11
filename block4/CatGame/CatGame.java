import java.util.Arrays;

public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int n = coordinates.length;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(coordinates);

        for (int i = 0; i < n; i++) {
            int left = coordinates[i] - X;
            int right = left + 2 * X;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int c : coordinates) {
                if (c < left) min = Math.min(min, c + X);
                else if (c > right) max = Math.max(max, c - X);
            }

            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) ans = 0;
            else if (min == Integer.MAX_VALUE) ans = Math.min(ans, max - right);
            else if (max == Integer.MIN_VALUE) ans = Math.min(ans, left - min);
            else ans = Math.min(ans, max - min);
        }

        return Math.max(0, ans);
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
