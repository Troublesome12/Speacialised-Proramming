import java.util.*;

public class RoughStrings {
    public int minRoughness(String s, int n) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        List<Integer> list = new ArrayList<>();
        for (int f : freq) if (f > 0) list.add(f);

        int ans = Integer.MAX_VALUE;
        for (int maxFreq = 1; maxFreq <= 50; maxFreq++) {
            int removeHigh = 0;
            for (int f : list)
                if (f > maxFreq) removeHigh += f - maxFreq;
            if (removeHigh > n) continue;

            int remain = n - removeHigh;
            List<Integer> low = new ArrayList<>();
            for (int f : list)
                if (f <= maxFreq) low.add(f);
            Collections.sort(low);

            int idx = 0;
            while (idx < low.size() && remain >= low.get(idx)) {
                remain -= low.get(idx);
                low.set(idx, 0);
                idx++;
            }

            int minFreq = Integer.MAX_VALUE;
            for (int f : low)
                if (f > 0 && f < minFreq) minFreq = f;
            if (minFreq == Integer.MAX_VALUE) minFreq = 0;

            ans = Math.min(ans, maxFreq - minFreq);
        }
        return ans;
    }

    public static void main(String[] args) {
        RoughStrings rs = new RoughStrings();
        System.out.println(rs.minRoughness("aaaaabbc", 1));                                         // 3
        System.out.println(rs.minRoughness("aaaabbbbc", 5));                                        // 0
        System.out.println(rs.minRoughness("veryeviltestcase", 1));                                 // 2
        System.out.println(rs.minRoughness("gggggggooooooodddddddllllllluuuuuuuccckkk", 5));        // 3
        System.out.println(rs.minRoughness("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", 17));   // 0
        System.out.println(rs.minRoughness("bbbccca", 2));                                          // 0
    }
}
