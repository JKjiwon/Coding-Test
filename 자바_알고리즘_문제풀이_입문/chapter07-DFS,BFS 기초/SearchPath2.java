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
// 정점의 개수가 많아지면 인접리스트 사용
class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int N, M, answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        
        Main t = new Main();
        t.dfs(1);
        System.out.println(answer);
    }

    public void dfs(int v) {
        if(v == N) {
            answer++;
            return;
        }
        visited[v] = true;
        for(int nv : graph.get(v)) {
            if(!visited[nv]) {
                dfs(nv);
                visited[nv] = false;
            }
        }
    }   
}