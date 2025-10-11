import java.util.*;

public class CellRemoval {
    public int cellsLeft(int[] parent, int deletedCell) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();

        // Initialize children list
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) root = i;
            else children.get(parent[i]).add(i);
        }

        // Mark deleted cells via DFS
        boolean[] deleted = new boolean[n];
        deleteDFS(deletedCell, children, deleted);

        // If root itself deleted
        if (deleted[root]) return 0;

        // Count leaf nodes
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (deleted[i]) continue;
            boolean hasAliveChild = false;
            for (int c : children.get(i)) {
                if (!deleted[c]) {
                    hasAliveChild = true;
                    break;
                }
            }
            if (!hasAliveChild) count++;
        }
        return count;
    }

    private void deleteDFS(int node, List<List<Integer>> children, boolean[] deleted) {
        deleted[node] = true;
        for (int child : children.get(node)) {
            deleteDFS(child, children, deleted);
        }
    }

    public static void main(String[] args) {
        CellRemoval cr = new CellRemoval();
        System.out.println(cr.cellsLeft(new int[]{-1,0,0,1,1}, 2)); // 2
        System.out.println(cr.cellsLeft(new int[]{-1,0,0,1,1}, 1)); // 1
        System.out.println(cr.cellsLeft(new int[]{-1,0,0,1,1}, 0)); // 0
        System.out.println(cr.cellsLeft(new int[]{-1,0,0,2,2,4,4,6,6}, 4)); // 2
        System.out.println(cr.cellsLeft(new int[]{26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43,
          35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14}, 24)); // 14
    }
}
