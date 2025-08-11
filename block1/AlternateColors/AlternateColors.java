public class AlternateColors {
    
    public String getColor(long r, long g, long b, long k) {
        String[] temp = new String[(int) k + 3];

        for (int i=0; i<=k;) {
            for (int j=1; j<=3; j++) {
                if ((j % 3 == 1) && (r > 0)) {
                    temp[i] = "RED";
                    r--;
                    i++;
                }
                else if ((j % 3 == 2) && (g > 0)) {
                    temp[i] = "GREEN";
                    g--;
                    i++;
                }
                else if ((j % 3 == 0) && (b > 0)) {
                    temp[i] = "BLUE";
                    b--;
                    i++;
                }
            }
        }
        return temp[(int) k - 1];
    }
}
