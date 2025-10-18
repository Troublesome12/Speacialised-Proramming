import java.util.*;

public class FamilyTravel {
    public int shortest(String[] edges) {
        int n = edges.length;
        // Convert char to weight: 'a'..'z' => 1..26, 'A'..'Z' => 27..52, '0' => 0 (no edge)
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] row = edges[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char c = row[j];
                if (c == '0') w[i][j] = 0;
                else if ('a' <= c && c <= 'z') w[i][j] = c - 'a' + 1;
                else w[i][j] = c - 'A' + 27;
            }
        }

        final int MAX_LEN = 53; // sentinel "infinite" previous length (first hop can be any 1..52)
        final int INF = 1_000_000_000;

        // dist[city][lastLen] -> shortest total cost to reach city with last edge length = lastLen
        int[][] dist = new int[n][MAX_LEN + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        // Dijkstra's PQ over (cost, city, lastLen)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        dist[0][MAX_LEN] = 0;
        pq.add(new Node(0, MAX_LEN, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost != dist[cur.city][cur.lastLen]) continue; // stale

            int u = cur.city;
            int last = cur.lastLen;

            for (int v = 0; v < n; v++) {
                int len = w[u][v];
                if (len == 0) continue;        // no edge
                if (len > last) continue;      // violates non-increasing constraint

                int ncost = cur.cost + len;
                if (ncost < dist[v][len]) {
                    dist[v][len] = ncost;
                    pq.add(new Node(v, len, ncost));
                }
            }
        }

        // Best among all last edge lengths at city 1
        int ans = INF;
        for (int last = 1; last <= MAX_LEN; last++) {
            ans = Math.min(ans, dist[1][last]);
        }
        return ans == INF ? -1 : ans;
    }

    static class Node {
        int city, lastLen, cost;
        Node(int c, int l, int cost) { this.city = c; this.lastLen = l; this.cost = cost; }
    }

    public static void main(String[] args) {
        FamilyTravel ft = new FamilyTravel();
        System.out.println(ft.shortest(new String[]{"0ze","z0c","ec0"}));                           //8
        System.out.println(ft.shortest(new String[]{"0zc","z0e","ce0"}));                           //26
        System.out.println(ft.shortest(new String[]{"0Zej0","Z0fkh","ef00d","jk00i","0hdi0"}));     //27
        System.out.println(ft.shortest(new String[]{"00z00","0000a","z00bb","00b0b","0abb0"}));     //29
        System.out.println(ft.shortest(new String[]{"000a", "00a0", "0a0a", "a0a0"}));              //3
    }
}
