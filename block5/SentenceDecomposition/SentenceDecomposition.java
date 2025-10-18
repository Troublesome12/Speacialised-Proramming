import java.util.*;

public class SentenceDecomposition {
    public int decompose(String sentence, String[] validWords) {
        int n = sentence.length();
        // Preprocess valid words: cache length, frequency, and char array
        int m = validWords.length;
        int[] wlen = new int[m];
        int[][] wfreq = new int[m][26];
        char[][] wchars = new char[m][];
        for (int i = 0; i < m; i++) {
            String w = validWords[i];
            wlen[i] = w.length();
            wchars[i] = w.toCharArray();
            for (char c : wchars[i]) wfreq[i][c - 'a']++;
        }

        final int INF = 1_000_000_000;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        // For each start index, try every valid word
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < m; k++) {
                int L = wlen[k];
                if (i + L > n) continue;

                // Quick anagram check with frequency counts
                if (!isAnagram(sentence, i, L, wfreq[k])) continue;

                // Count equal positions to compute minimal cost
                int same = 0;
                for (int t = 0; t < L; t++) {
                    if (sentence.charAt(i + t) == wchars[k][t]) same++;
                }
                int cost = L - same;

                if (dp[i + L] != INF) {
                    dp[i] = Math.min(dp[i], cost + dp[i + L]);
                }
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }

    // Check if sentence[i..i+L) is an anagram of a word with given freq
    private boolean isAnagram(String s, int start, int L, int[] freqWord) {
        int[] f = new int[26];
        for (int j = 0; j < L; j++) {
            f[s.charAt(start + j) - 'a']++;
        }
        for (int c = 0; c < 26; c++) {
            if (f[c] != freqWord[c]) return false;
        }
        return true;
    }
}
