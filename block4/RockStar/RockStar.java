public class RockStar {
    public int getNumSongs(int ff, int fs, int sf, int ss) {
        // Case 1: No fast-start songs
        if (ff + fs == 0) {
            return ss + (sf > 0 ? 1 : 0);
        }

        // Case 2: There is at least one fast-start song
        int result = ff;
        if (fs > 0) {
            // transition fast→slow and continue slow chain
            result += 1 + ss + Math.min(sf, ss);
        }
        return result;
    }

    public static void main(String[] args) {
        RockStar rs = new RockStar();
        System.out.println(rs.getNumSongs(100, 0, 0, 200)); // 100
        System.out.println(rs.getNumSongs(0, 0, 20, 200));  // 201
        System.out.println(rs.getNumSongs(1, 2, 1, 1));     // 5
        System.out.println(rs.getNumSongs(192, 279, 971, 249)); // 999
    }
}
