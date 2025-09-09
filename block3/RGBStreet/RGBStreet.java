public class RGBStreet {
    public int estimateCost(String[] houses) {
        int n = houses.length;
        int[][] cost = new int[n][3];

        // Parse input costs
        for (int i = 0; i < n; i++) {
            String[] parts = houses[i].split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // DP table: dp[i][c] = min cost to paint up to house i, with house i color c
        int[][] dp = new int[n][3];
        // Initialize first house
        for (int c = 0; c < 3; c++) {
            dp[0][c] = cost[0][c];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 3; c++) {
                dp[i][c] = cost[i][c] + Math.min(dp[i-1][(c+1)%3], dp[i-1][(c+2)%3]);
            }
        }

        // The answer is the minimum cost to paint the last house any color
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

    public static void main(String[] args) {
        System.out.println(new RGBStreet().estimateCost(new String[]{"1 100 100", "100 1 100", "100 100 1"}));       // 3
    }
}