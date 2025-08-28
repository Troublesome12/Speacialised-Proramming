public class QuickSums {
    private int best;

    public int minSums(String numbers, int sum) {
        best = Integer.MAX_VALUE;
        dfs(numbers, 0, 0L, 0, sum);
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private void dfs(String s, int pos, long currSum, int plusCount, int target) {
        int n = s.length();
        if (pos == n) {
            if (currSum == target) best = Math.min(best, plusCount);
            return;
        }
        // If we already exceed, no need to continue
        if (currSum > target) return;

        long val = 0;
        for (int end = pos; end < n; end++) {
            // Build the next term incrementally to avoid repeated substring parsing
            val = val * 10 + (s.charAt(end) - '0');

            // Prune if this term already makes us exceed the target
            if (currSum + val > target) break;

            // Take [pos..end] as one number; add a plus if it's not the first term
            dfs(s, end + 1, currSum + val, plusCount + (pos == 0 ? 0 : 1), target);
        }
    }

    // quick test
    public static void main(String[] args) {
        QuickSums qs = new QuickSums();
        System.out.println(qs.minSums("99999", 45));         // 4
        System.out.println(qs.minSums("1110", 3));           // 3
        System.out.println(qs.minSums("0123456789", 45));    // 8
        System.out.println(qs.minSums("99999", 100));        // -1
        System.out.println(qs.minSums("382834", 100));       // 2
        System.out.println(qs.minSums("9230560001", 71));    // 4
    }
}
