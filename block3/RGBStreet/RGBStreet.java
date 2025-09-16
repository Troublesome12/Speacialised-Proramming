import java.util.*;

public class RGBStreet {
    public int estimateCost(String[] houses) {
        int n = houses.length;
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] parts = houses[i].trim().split("\\s+");
            cost[i][0] = Integer.parseInt(parts[0]); // R
            cost[i][1] = Integer.parseInt(parts[1]); // G
            cost[i][2] = Integer.parseInt(parts[2]); // B
        }

        int[] dp = Arrays.copyOf(cost[0], 3); // base: first house
        for (int i = 1; i < n; i++) {
            int r = cost[i][0] + Math.min(dp[1], dp[2]);
            int g = cost[i][1] + Math.min(dp[0], dp[2]);
            int b = cost[i][2] + Math.min(dp[0], dp[1]);
            dp[0] = r; dp[1] = g; dp[2] = b;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        System.out.println(new RGBStreet().estimateCost(new String[]{"1 100 100", "100 1 100", "100 100 1"}));
        System.out.println(new RGBStreet().estimateCost(new String[]{"1 100 100", "100 100 100", "1 100 100"}));
        System.out.println(new RGBStreet().estimateCost(new String[]{"26 40 83", "49 60 57", "13 89 99"}));
        System.out.println(new RGBStreet().estimateCost(new String[]{"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"}));
        System.out.println(new RGBStreet().estimateCost(new String[]{"71 39 44", "32 83 55", "51 37 63", "89 29 100", "83 58 11", "65 13 15", "47 25 29", "60 66 19"}));
    }
}
