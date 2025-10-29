public class HouseBuilding {
    public int getMinimum(String[] area) {
        int n = area.length;
        int m = area[0].length();
        int ans = Integer.MAX_VALUE;

        for (int base = 0; base <= 9; base++) {
            int totalEffort = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int h = area[i].charAt(j) - '0';
                    if (h < base) totalEffort += base - h;
                    else if (h > base + 1) totalEffort += h - (base + 1);
                }
            }
            ans = Math.min(ans, totalEffort);
        }
        return ans;
    }

    public static void main(String[] args) {
        HouseBuilding hb = new HouseBuilding();
        System.out.println(hb.getMinimum(new String[]{"10", "31"}));        // 2
        System.out.println(hb.getMinimum(new String[]{"54454", "61551"}));  // 7
        System.out.println(hb.getMinimum(new String[]{"989"}));             // 0
        System.out.println(hb.getMinimum(new String[]{"90"}));              // 8
        System.out.println(hb.getMinimum(new String[]{
            "5781252", "2471255", "0000291", "1212489"}));                  // 53
    }
}
