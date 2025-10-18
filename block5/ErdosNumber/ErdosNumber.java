import java.util.*;

public class ErdosNumber {
    public String[] calculateNumbers(String[] publications) {
        // Build co-authorship graph and collect all authors
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> allAuthors = new HashSet<>();

        for (String pub : publications) {
            String[] names = pub.split(" ");
            // ensure nodes exist
            for (String a : names) {
                graph.computeIfAbsent(a, k -> new HashSet<>());
                allAuthors.add(a);
            }
            // add undirected edges between all pairs on this paper
            for (int i = 0; i < names.length; i++) {
                for (int j = i + 1; j < names.length; j++) {
                    graph.get(names[i]).add(names[j]);
                    graph.get(names[j]).add(names[i]);
                }
            }
        }

        // BFS from ERDOS to compute distances
        Map<String, Integer> dist = new HashMap<>();
        if (graph.containsKey("ERDOS")) {
            Queue<String> q = new ArrayDeque<>();
            dist.put("ERDOS", 0);
            q.add("ERDOS");
            while (!q.isEmpty()) {
                String u = q.poll();
                int d = dist.get(u);
                for (String v : graph.getOrDefault(u, Collections.emptySet())) {
                    if (!dist.containsKey(v)) {
                        dist.put(v, d + 1);
                        q.add(v);
                    }
                }
            }
        }

        // Build result lines for all authors (finite numbers only if reachable)
        String[] out = new String[allAuthors.size()];
        int idx = 0;
        for (String a : allAuthors) {
            if (dist.containsKey(a)) out[idx++] = a + " " + dist.get(a);
            else out[idx++] = a;
        }

        // Lexicographic order
        Arrays.sort(out);
        return out;
    }

    public static void main(String[] args) {
        ErdosNumber en = new ErdosNumber();
        System.out.println(Arrays.toString(en.calculateNumbers(new String[]{"ERDOS"})));
        System.out.println(Arrays.toString(en.calculateNumbers(new String[]{"KLEITMAN LANDER", "ERDOS KLEITMAN"})));
        System.out.println(Arrays.toString(en.calculateNumbers(new String[]{"ERDOS A", "A B", "B AA C"})));
        System.out.println(Arrays.toString(en.calculateNumbers(new String[]{"ERDOS B", "A B C", "B A E", "D F"})));
        System.out.println(Arrays.toString(en.calculateNumbers(new String[]{
            "ERDOS KLEITMAN",
            "CHUNG GODDARD KLEITMAN WAYNE",
            "WAYNE GODDARD KLEITMAN",
            "ALON KLEITMAN",
            "DEAN GODDARD WAYNE KLEITMAN STURTEVANT"})));
    }
}
