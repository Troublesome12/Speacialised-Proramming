public class RugSizes {
    
    public	int rugCount(int area) {
        int count = 0;
        int j;
        for(int i=1; i<area; i++) {
            if (area%i == 0) {
                j = area/i;

                if ((i%2 != 0 || j%2 != 0) || (i == j)){
                    count++;
                }
            }
        }
        return count;
    }
}
