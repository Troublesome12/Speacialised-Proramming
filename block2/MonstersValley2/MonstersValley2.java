public class MonstersValley2 {
    public static void main(String[] args) {
        System.out.println(new MonstersValley2().minimumPrice(new int[]{8, 5, 10}, new int[]{1, 1, 2}));
    }

    public int minimumPrice(int[] dread, int[] price) {
        int n = dread.length;
        int maxPrice = n * 2; // Worst case: all prices are 2
        long[][] dp = new long[n + 1][maxPrice + 1];

        // Initialize dp table with -1 (unreachable state)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxPrice; j++) {
                dp[i][j] = -1;
            }
        }

        // Base case: no monsters yet, 0 cost, 0 dread
        dp[0][0] = 0;

        // Process each monster
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxPrice; j++) {
                if ()

            }
        }


        return 0;
    }
}
