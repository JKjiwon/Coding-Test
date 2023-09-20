package thisiscodingtest.grape;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */

public class Sol2 {
    public static void main(String[] args) {
        int sum = 0;
        int maxCost = 0;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Road> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            pq.offer(new Road(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        while (!pq.isEmpty()) {
            Road road = pq.poll();
            if (find(parent, road.a) != find(parent, road.b)) {
                union(parent, road.a, road.b);
                sum += road.cost;
                maxCost = road.cost;
            }
        }
        System.out.println(sum - maxCost);
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static class Road implements Comparable<Road> {
        int a;
        int b;
        int cost;

        public Road(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull Road other) {
            return this.cost - other.cost;
        }
    }
}
