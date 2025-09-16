public class UnsealTheSafe {
    // Adjacency list by digit index (0..9) per the keypad edges
    private static final int[][] NEXT = new int[][]{
        /*0*/ {7},
        /*1*/ {2,4},
        /*2*/ {1,3,5},
        /*3*/ {2,6},
        /*4*/ {1,5,7},
        /*5*/ {2,4,6,8},
        /*6*/ {3,5,9},
        /*7*/ {4,8,0},
        /*8*/ {5,7,9},
        /*9*/ {6,8}
    };

    public long countPasswords(int N) {
        // dp[d] = number of ways to end at digit d for current length
        long[] dp = new long[10];
        // Base: length 1 → any single digit
        for (int d = 0; d <= 9; d++) dp[d] = 1;

        // Extend to length N by iterating N-1 transitions
        for (int len = 2; len <= N; len++) {
            long[] next = new long[10];
            for (int d = 0; d <= 9; d++) {
                for (int nd : NEXT[d]) {
                    next[nd] += dp[d];
                }
            }
            dp = next;
        }

        long total = 0;
        for (int d = 0; d <= 9; d++) total += dp[d];
        return total;
    }

    public static void main(String args []) {
        System.out.println(new UnsealTheSafe().countPasswords(2));
        System.out.println(new UnsealTheSafe().countPasswords(3));
        System.out.println(new UnsealTheSafe().countPasswords(25));
    }
}
