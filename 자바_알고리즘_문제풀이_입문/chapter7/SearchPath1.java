import java.util.*;
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
class Main {

    static int[][] graph;
    static boolean[] visited;
    static int N, M, answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        
        Main t = new Main();
        visited[1] = true;
        t.dfs(1);
        System.out.println(answer);
    }

    public void dfs(int v) {
        if(v == N) {
            answer++;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }   
}