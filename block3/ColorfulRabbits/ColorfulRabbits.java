import java.util.*;

public class ColorfulRabbits {
    public int getMinimum(int[] replies) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int r : replies) freq.put(r, freq.getOrDefault(r, 0) + 1);

        long total = 0; // long internally, cast to int at end (fits constraints)
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int x = e.getKey();
            int cnt = e.getValue();
            int groupSize = x + 1;
            int groups = (cnt + groupSize - 1) / groupSize; // ceil(cnt / groupSize)
            total += (long) groups * groupSize;
        }
        return (int) total;
    }

    // quick checks
    public static void main(String[] args) {
        ColorfulRabbits c = new ColorfulRabbits();
        System.out.println(c.getMinimum(new int[]{1,1,2,2})); // 5
        System.out.println(c.getMinimum(new int[]{0}));       // 1
        System.out.println(c.getMinimum(new int[]{2,2,44,2,2,2,444,2,2})); // 499
    }
}
