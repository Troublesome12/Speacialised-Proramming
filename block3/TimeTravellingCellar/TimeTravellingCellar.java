public class TimeTravellingCellar {
    public int determineProfit(int[] profit, int[] decay) {
        int n = profit.length;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {           // choose cellar to advance
            for (int j = 0; j < n; j++) {       // choose different cellar to turn back
                if (i == j) continue;
                best = Math.max(best, profit[i] - decay[j]);
            }
        }
        return best; // guaranteed positive per problem statement
    }

    // quick check against the samples
    public static void main(String[] args) {
        TimeTravellingCellar t = new TimeTravellingCellar();
        System.out.println(t.determineProfit(new int[]{1,2,3}, new int[]{3,1,2})); // 2
        System.out.println(t.determineProfit(new int[]{3,2},   new int[]{1,2}));   // 1
        System.out.println(t.determineProfit(new int[]{3,3,3}, new int[]{1,1,1})); // 2
        System.out.println(t.determineProfit(new int[]{1000,500,250,125}, new int[]{64,32,16,8})); // 992
    }
}
