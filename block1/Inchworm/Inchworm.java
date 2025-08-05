import java.util.ArrayList;

public class Inchworm {
    public static int lunchtime(int branch, int rest, int leaf) {
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i=0;i<=branch;i+=leaf) {
            leaves.add(i);
        }
        System.out.println(leaves);
        int count = 0;
        for (int i: leaves) {
            if (i % rest == 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(lunchtime(1000, 7, 3));
    }
}
