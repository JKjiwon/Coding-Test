package thisiscodingtest.grape;

import java.util.Scanner;
/*
6 4
1 4
2 3
2 4
5 6
 */
public class UnionFind {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(parent, a, b);
        }

        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i < N + 1; i++) {
            System.out.print(find(parent, i) + " ");
        }
        System.out.println();
        System.out.print("부모 테이블: ");
        for (int i = 1; i < N + 1; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
