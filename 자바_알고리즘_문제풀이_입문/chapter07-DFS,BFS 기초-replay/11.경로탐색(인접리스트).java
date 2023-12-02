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
    static List<List<Integer>> edges;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        edges = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            edges.get(s).add(e);
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

        for (Integer to : edges.get(x)) {
            if (!visited[to]) {
                visited[to] = true;
                dfs(to);
                visited[to] = false;
            }
        }
    }
}