/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */

import java.util.*;


public class Main {
    static int N, M;
    static boolean[][] edges;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        edges = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            edges[s][e] = true;
        }

        visited[1] = true;
        T.dfs(1);

        System.out.println(cnt);
    }

    public void dfs(int x) {
        if (x == N) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (edges[x][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }
}