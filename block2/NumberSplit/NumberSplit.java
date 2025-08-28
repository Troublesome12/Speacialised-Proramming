import java.util.HashMap;
import java.util.Map;

public class NumberSplit {
    private final Map<Long, Integer> memo = new HashMap<>();

    public int longestSequence(int start) {
        return dfs(start);
    }

    private int dfs(long n) {
        if (n < 10) return 1;                 // single-digit ends the sequence
        Integer got = memo.get(n);
        if (got != null) return got;

        char[] d = Long.toString(n).toCharArray();
        int L = d.length;
        int best = 1; // at least the number itself

        // Try all non-empty subsets of cut positions among (L-1) gaps
        int gaps = L - 1;
        for (int mask = 1; mask < (1 << gaps); mask++) {
            long prod = 1;
            long part = 0;
            for (int i = 0; i < L; i++) {
                part = part * 10 + (d[i] - '0'); // build current part
                // if there is a cut after position i (i < L-1 and bit i set)
                if (i < L - 1 && ((mask >> i) & 1) == 1) {
                    prod *= part;
                    part = 0;
                    if (prod == 0) break; // early exit: will end quickly
                }
            }
            prod *= part; // multiply the last part

            int cand = 1 + dfs(prod);
            if (cand > best) best = cand;
        }

        memo.put(n, best);
        return best;
    }

    // quick tests
    public static void main(String[] args) {
        NumberSplit ns = new NumberSplit();
        System.out.println(ns.longestSequence(6));      // 1
        System.out.println(ns.longestSequence(97));     // 4
        System.out.println(ns.longestSequence(234));    // 5
        System.out.println(ns.longestSequence(876));    // 7
        System.out.println(ns.longestSequence(99999));  // 29
    }
}
