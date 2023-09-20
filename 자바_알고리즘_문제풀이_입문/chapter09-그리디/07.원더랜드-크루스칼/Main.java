import java.util.*;

public class Main {
    static int V, E;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Path> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            pq.offer(new Path(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        
        int sum = 0;
        while (!pq.isEmpty()) {
            Path path = pq.poll();

            if (find(path.a) != find(path.b)) {
                union(path.a, path.b);
                sum += path.distance;
            }
        }

        System.out.println(sum);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static class Path implements Comparable<Path> {
        int a;
        int b;
        int distance;

        public Path(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Path other) {
            return this.distance - other.distance;
        }
    }
}