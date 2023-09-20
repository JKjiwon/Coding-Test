import java.util.*;

public class Main {
    static int V, E;
    static boolean[] visited;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();
            graph.get(a).add(new Edge(b, distance));
            graph.get(b).add(new Edge(a, distance));
        }
        
        // prim's algorithm
        // 1. 그래프에서 거리가 작은 edge를 선택한다.
        // 2. edge로 가는 노드가 이미 방문한 노드이면 무시한다.
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int sum = 0;

        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visited[cur.vertex]) {
                continue;
            }
            
            visited[cur.vertex] = true;
            sum += cur.distance;

            for (Edge next : graph.get(cur.vertex)) {
                if (!visited[next.vertex]) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sum);
    }

    static class Edge implements Comparable<Edge> {
        public int vertex;
        public int distance;

        public Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other) {
            return this.distance - other.distance;
        }
    }
}