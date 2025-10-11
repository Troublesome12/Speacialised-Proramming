public class CatGame {
    public int getNumber(int[] coordinates, int X) {
        int Lmax = Integer.MIN_VALUE;
        int Rmin = Integer.MAX_VALUE;

        for (int c : coordinates) {
            Lmax = Math.max(Lmax, c - X);
            Rmin = Math.min(Rmin, c + X);
        }

        return Math.max(0, Lmax - Rmin);
    }
    
    public static void main(String[] args) {
        CatGame cg = new CatGame();
        System.out.println(cg.getNumber(new int[]{-3, 0, 1}, 3)); // 3
        System.out.println(cg.getNumber(new int[]{4, 7, -7}, 5)); // 4
        System.out.println(cg.getNumber(new int[]{-100000000, 100000000}, 100000000)); // 0
        System.out.println(cg.getNumber(new int[]{3,7,4,6,-10,7,10,9,-5},7)); // 7
        System.out.println(cg.getNumber(new int[]{-4, 0, 4, 0},4)); // 4
        System.out.println(cg.getNumber(new int[]{7},0)); // 0
    }
}
