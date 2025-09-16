public class MatchNumbersEasy {
    public String maxNumber(int[] matches, int n) {
        int k = matches.length;

        // dp[m] = max number of digits formable using at most m matches
        int[] dp = new int[n + 1];
        for (int d = 0; d < k; d++) {
            int c = matches[d];
            for (int m = c; m <= n; m++) {
                dp[m] = Math.max(dp[m], dp[m - c] + 1);
            }
        }

        // If no nonzero digit is affordable, the only valid number is "0"
        boolean anyNonZeroAffordable = false;
        for (int d = 1; d < k; d++) if (matches[d] <= n) { anyNonZeroAffordable = true; break; }
        if (!anyNonZeroAffordable) return "0";

        // Choose the first digit: maximize total length (1 + dp[n - cost]),
        // tie-break by larger digit.
        int firstDigit = -1, firstCost = 0, bestLen = -1;
        for (int d = k - 1; d >= 1; d--) {
            int c = matches[d];
            if (c <= n) {
                int candLen = 1 + dp[n - c];
                if (candLen > bestLen || (candLen == bestLen && d > firstDigit)) {
                    bestLen = candLen;
                    firstDigit = d;
                    firstCost = c;
                }
            }
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();
        ans.append(firstDigit);

        int remainingMatches = n - firstCost;
        int remainingLen = bestLen - 1;

        // For the rest, 0 is allowed; pick largest digit that still allows completion
        while (remainingLen > 0) {
            for (int d = k - 1; d >= 0; d--) {
                int c = matches[d];
                if (c <= remainingMatches) {
                    // We need to be able to finish remainingLen-1 digits with at most (remainingMatches - c) matches
                    if (dp[remainingMatches - c] >= remainingLen - 1) {
                        ans.append(d);
                        remainingMatches -= c;
                        remainingLen--;
                        break;
                    }
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MatchNumbersEasy().maxNumber(new int[]{6,7,8}, 21));
        System.out.println(new MatchNumbersEasy().maxNumber(new int[]{5,23,24}, 30));
        System.out.println(new MatchNumbersEasy().maxNumber(new int[]{1,5,3,2}, 1));
        System.out.println(new MatchNumbersEasy().maxNumber(new int[]{1,1,1,1,1,1,1,1,1,1}, 50));
    }
}
