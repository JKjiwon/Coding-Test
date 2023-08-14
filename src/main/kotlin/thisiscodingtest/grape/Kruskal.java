package thisiscodingtest.grape;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */

/**
 * 크루스칼 알고리즘(그리디) - 최소 신장 트리 찾기
 * <p>
 * <p>
 * 무향 그래프에서 가능
 * 신장 트리: 하나의 그래프가 있을 때, 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
 * <p>
 * 두 그래프를 잇는 최소 비용: 정렬
 * <p>
 * 사이클 여부: union-find
 * <p>
 * 간선의 개수: E개
 * <p>
 * 시간 복잡도: O(ElogE)
 */
public class Kruskal {
    public static void main(String[] args) {
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();
            pq.offer(new Edge(a, b, cost));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(parent, edge.a) != find(parent, edge.b)) {
                union(parent, edge.a, edge.b);
                sum += edge.cost;
            }
        }

        System.out.println(sum);
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

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull Edge other) {
            return this.cost - other.cost;
        }
    }
}
