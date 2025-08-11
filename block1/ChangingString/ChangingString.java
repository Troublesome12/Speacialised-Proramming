import java.util.Arrays;
import java.util.Collections;

public class ChangingString {

    public int distance(String A, String B, int K) {
        int length = A.length();
        Integer[] distances = new Integer[length];
        for (int i=0; i<length; i++) {
            distances[i] = Math.abs(A.charAt(i) - B.charAt(i));
        }

        Arrays.sort(distances, Collections.reverseOrder());     // descending
        int totalDistance = 0;

        for (int i=0; i<length; i++) {
            if ((distances[i] > 0) && (K > 0))
                K--;
            else if (distances[i] > 0)
                totalDistance += distances[i];
            else if (K > 0)
                totalDistance++;
                K--;
        }
        return totalDistance;
    }
}
