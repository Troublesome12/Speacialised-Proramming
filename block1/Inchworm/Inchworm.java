public class Inchworm {

    public int lunchtime(int branch, int rest, int leaf) {
        int count = 0;
        for(int i=0;i<=branch;i+=leaf) {
            if (i % rest == 0) {
                count++;
            }
        }
        return count;
    }
}
