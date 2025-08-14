import java.util.ArrayList;

public class RugSizes {

    public int rugCount(int area) {
        int count = 0;
        int j;
        ArrayList<Integer> multiplier = new ArrayList<Integer>();

        if (area == 1) {
            return area;
        }
        
        for(int i=1; i<area; i++) {
            if (area%i == 0) {
                j = area/i;

                if ((i%2 != 0 || j%2 != 0) || (i == j)){
                    if (multiplier.contains(i)) {
                        continue;
                    }
                    multiplier.add(j);
                    count++;
                }
            }
        }
        return count;
    }
}
