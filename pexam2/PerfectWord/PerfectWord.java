public class PerfectWord {
    
    public int longest(String W) {
        int length = W.length();
        if (length == 0) return 0;
        int[] dp = new int[length];
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (W.charAt(j) <= W.charAt(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectWord().longest("ABCDEFG"));   // 7
        System.out.println(new PerfectWord().longest("GFEDCBA"));   // 1
        System.out.println(new PerfectWord().longest("ACBB"));      // 3
        System.out.println(new PerfectWord().longest("ACCCCBB"));   // 5
    }
}