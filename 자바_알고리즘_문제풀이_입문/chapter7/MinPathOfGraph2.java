import java.util.*;

/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
*/
class Main {

    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] answer;
    final static int MAX_VALUE = 987654321;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        visited = new boolean[N + 1];
        
        answer = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        
        Main t = new Main();
        t.bfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.printf("%d : %d\n", i, answer[i]);
        }
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    queue.offer(nv);
                    answer[nv] = answer[cv] + 1; // 모든 노드는 한번씩만 방문하므로 answer[v]는 최소값이 된다.
                }
            }
        }
    }
    
    // 각 노드의 level이 최소값이 된다.
    public void bfs2(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int v = queue.poll();
                answer[v] = Math.min(level, answer[v]);

                for(int nv : graph.get(v)) {
                    if (!visited[nv]) {
                        visited[nv] = true;
                        queue.offer(nv);
                    }
                }
            }
            level++;
        }
    }
}