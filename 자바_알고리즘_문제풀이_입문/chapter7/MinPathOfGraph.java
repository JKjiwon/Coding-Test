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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        
        Main t = new Main();
        for(int i = 2; i <= N; i++) {
            Arrays.fill(visited, false);
            System.out.printf("%d : %d\n", i, t.bfs(1, i));
        }
    }

    public int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int v = queue.poll();
                if(v == end) {
                    return level;
                }

                for(int nv : graph.get(v)) {
                    if (!visited[nv]) {
                        visited[nv] = true;
                        queue.offer(nv);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}