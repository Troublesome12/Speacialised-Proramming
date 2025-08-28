import java.util.Arrays;

public class MonstersValley2 {

    public int minimumPrice(int[] dread, int[] price) {
        int n = dread.length;
        int maxCost = 2 * n; // Worst case: all prices are 2
        long[][] dp = new long[n + 1][maxCost + 1];

        // Initialize dp table with -1 (unreachable state)
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base case: no monsters yet, 0 cost, 0 dread
        dp[0][0] = 0;

        // Process each monster
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= maxCost; c++) {
                if (dp[i][c] >= 0) {
                    // Option 1: bribe
                    int newCost = c + price[i];
                    if (newCost <= maxCost) {
                        dp[i + 1][newCost] = Math.max(dp[i + 1][newCost], dp[i][c] + dread[i]);
                    }
                    // Option 2: skip
                    if (dp[i][c] >= dread[i]) {
                        dp[i + 1][c] = Math.max(dp[i + 1][c], dp[i][c]);
                    }
                }
            }
        }

        for (int c = 0; c <= maxCost; c++) {
            if (dp[n][c] >= 0) return c;
        }
        return -1; // should never happen
    }

    public static void main(String[] args) {
        MonstersValley2 mv = new MonstersValley2();
        System.out.println(mv.minimumPrice(new int[]{8, 5, 10}, new int[]{1, 1, 2})); // 2
        System.out.println(mv.minimumPrice(new int[]{1, 2, 4, 1000000000}, new int[]{1, 1, 1, 2})); // 5
        System.out.println(mv.minimumPrice(new int[]{200, 107, 105, 206, 307, 400}, new int[]{1, 2, 1, 1, 1, 2})); // 2
        System.out.println(mv.minimumPrice(
                new int[]{5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333},
                new int[]{2, 2, 1, 1, 1, 1, 2, 1, 2, 1}));
    }
}
