public class AlternateColors {
    public String getColor(long r, long g, long b, long k) {
        long fullCycles = Math.min(r, Math.min(g, b));
        long fullCycleBalls = fullCycles * 3;

        if (k <= fullCycleBalls) {
            int pos = (int)(k % 3);
            if (pos == 1) return "RED";
            if (pos == 2) return "GREEN";
            return "BLUE"; // pos == 0
        }

        long leftK = k - fullCycleBalls;

        long[] counts = new long[] {r - fullCycles, g - fullCycles, b - fullCycles};
        String[] colors = new String[] {"RED", "GREEN", "BLUE"};

        // Filter colors with leftover > 0 and remember their indexes
        int availableCount = 0;
        int[] availableIndices = new int[3];
        for (int i = 0; i < 3; i++) {
            if (counts[i] > 0) {
                availableIndices[availableCount++] = i;
            }
        }

        int cycleLen = availableCount;
        long fullLeftCycles = (leftK - 1) / cycleLen;
        int posInCycle = (int)((leftK - 1) % cycleLen);

        // Find the color index in the leftover cycle that still has balls left
        for (int i = 0; i < cycleLen; i++) {
            int idx = availableIndices[(posInCycle + i) % cycleLen];
            if (counts[idx] > fullLeftCycles) {
                return colors[idx];
            }
        }

        // Should never happen
        return "UNKNOWN";
    }
}
