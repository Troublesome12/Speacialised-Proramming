public class DengklekBuildingRoads {
    static final int MOD = 1_000_000_007;

    public int numWays(int N, int M, int K) {
        int size = 1 << K;
        long[][] dp = new long[size][M + 1];
        dp[0][0] = 1;

        int MAXC = 100;
        long[][] C = new long[MAXC + 1][MAXC + 1];
        for (int n = 0; n <= MAXC; n++) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; k++)
                C[n][k] = (C[n - 1][k - 1] + C[n - 1][k]) % MOD;
        }

        for (int i = 1; i <= N; i++) {
            long[][] ndp = new long[size][M + 1];
            int d = Math.min(K, i - 1);
            for (int mask = 0; mask < size; mask++) {
                for (int m = 0; m <= M; m++) {
                    long cur = dp[mask][m];
                    if (cur == 0) continue;
                    if (d == 0) {
                        if (i > K && ((mask >> (K - 1)) & 1) == 1) continue;
                        int nextMask = ((mask << 1) & (size - 1));
                        ndp[nextMask][m] = (ndp[nextMask][m] + cur) % MOD;
                        continue;
                    }
                    for (int s = 0; s < (1 << d); s++) {
                        int oddCnt = Integer.bitCount(s);
                        int mask2 = mask ^ s;
                        if (i > K && ((mask2 >> (K - 1)) & 1) == 1) continue;
                        int pCurrent = oddCnt & 1;
                        for (int t = oddCnt; t + m <= M; t++) {
                            int rem = t - oddCnt;
                            if ((rem & 1) != 0) continue;
                            int y = rem / 2;
                            if (y + d - 1 > MAXC) continue;
                            long ways = C[y + d - 1][d - 1];
                            int nextMask = ((mask2 << 1) & (size - 1)) | pCurrent;
                            ndp[nextMask][m + t] = (ndp[nextMask][m + t] + cur * ways) % MOD;
                        }
                    }
                }
            }
            dp = ndp;
        }
        return (int) dp[0][M];
    }

    public static void main(String[] args) {
        DengklekBuildingRoads dbr = new DengklekBuildingRoads();
        System.out.println(dbr.numWays(3, 4, 1));       // 3
        System.out.println(dbr.numWays(4, 3, 3));       // 4
        System.out.println(dbr.numWays(2, 1, 1));       // 0
        System.out.println(dbr.numWays(5, 0, 3));       // 1
        System.out.println(dbr.numWays(10, 20, 5));     // 26964424
    }
}
