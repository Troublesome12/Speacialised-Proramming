import java.util.Vector;

public class WarehouseRenovation {
    
    public int countDarkSquares (int R, int C, Vector<String> roomPlan) {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (roomPlan.get(i).charAt(j) == 'O') {
                    
                    for (int k = 0; k < C; k++) {
                        if (roomPlan.get(i).charAt(j) != '#') {
                            roomPlan.get(i).setCharAt(k, '*');
                    }
                }
            }
        }

        System.out.println(roomPlan);
        return 0;
    }
    public static void main(String[] args) {
        WarehouseRenovation obj = new WarehouseRenovation();
        Vector<String> plan = new Vector<String>(java.util.Arrays.asList(".....", ".O...", ".....", "....."));
        System.out.println(obj.countDarkSquares(4, 5, plan));
    }
}
