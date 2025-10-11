import java.util.Arrays;

public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        Arrays.sort(coordinates);
        int n = coordinates.length;
        int best = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            // first k cats move to +X, the rest move to -X
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            if (k > 0) {
                // +X group spans coordinates[0..k-1]
                minVal = Math.min(minVal, coordinates[0] + X);
                maxVal = Math.max(maxVal, coordinates[k - 1] + X);
            }
            if (k < n) {
                // -X group spans coordinates[k..n-1]
                minVal = Math.min(minVal, coordinates[k] - X);
                maxVal = Math.max(maxVal, coordinates[n - 1] - X);
            }

            best = Math.min(best, maxVal - minVal);
        }
        return best;
    }

    public static void main(String[] args) {
        CatGame cg = new CatGame();
        System.out.println(cg.getNumber(new int[]{-3, 0, 1}, 3)); // 3
        System.out.println(cg.getNumber(new int[]{4, 7, -7}, 5)); // 4
        System.out.println(cg.getNumber(new int[]{-100000000, 100000000}, 100000000)); // 0
        System.out.println(cg.getNumber(new int[]{3,7,4,6,-10,7,10,9,-5},7)); // 7
        System.out.println(cg.getNumber(new int[]{-4, 0, 4, 0},4)); // 4
        System.out.println(cg.getNumber(new int[]{7},0)); // 0
    }
}
