package thisiscodingtest.grape;

import java.util.Scanner;
/*
3 3
1 2
1 3
2 3
 */

/**
 * 무방향 그래프에서 사이클 발생 여부 판단(방향 그래프는 DFS를 통해서 판별 가능)
 * <p>
 * find 연산을 했을 때
 * 부모 노드가 같다면, 사이클이 발생했다고 판단
 * 부모 노드가 다르면, union 연산 수행
 */
public class CheckCycle {
    public static void main(String[] args) {
        boolean hasCycle = false;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] parents = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (find(parents, a) != find(parents, b)) {
                union(parents, a, b);
            } else {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            System.out.println("사이클 발생 O");
        } else {
            System.out.println("사이클 발생 X");
        }
    }

    private static int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }

    private static void union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
