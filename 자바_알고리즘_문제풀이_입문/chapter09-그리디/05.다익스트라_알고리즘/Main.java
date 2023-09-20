import java.util.*;
/*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/
public class Main {

    static int N, M;
    static List<List<Path>> graph = new ArrayList<>();
    static int[] distances;
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Path> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        distances = new int[N + 1];
        Arrays.fill(distances, INF);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();
            
            graph.get(from).add(new Path(to, distance));
        }

        dijkstra(1);

        for (int i = 2; i <= N; i++) {
            String dis;
            if (distances[i] == INF) {
                dis = "impossible";
            } else {
                dis = distances[i] + "";
            }

            System.out.printf("%d : %s\n", i, dis);
        }

    }

    static void dijkstra(int start) {
        distances[start] = 0;
        pq.offer(new Path(start, 0));
        
        while (!pq.isEmpty()) {
            Path cur = pq.poll();
            // distances[node]가 더 작은 값으로 업데이트 될 수 있으모로 확인 필요
            if (distances[cur.node] < cur.distance) {
                continue;
            }

            for (Path next : graph.get(cur.node)) {
                int cost = distances[cur.node] + next.distance;
                if (distances[next.node] > cost) {
                    distances[next.node] = cost;
                    pq.offer(new Path(next.node, cost));
                }
            }
        }
    }

    static class Path implements Comparable<Path> {
        int node;
        int distance;

        public Path(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(Path other) {
            return this.distance - other.distance;
        }
    }
}