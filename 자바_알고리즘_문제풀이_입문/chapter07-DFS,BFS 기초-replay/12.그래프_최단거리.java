import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> edges;
    static boolean[] visited;
    static int[] answer;
    static final int INF = 21;

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        edges = new ArrayList<>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N + 1; i++) {
            answer[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            edges.get(s).add(e);
        }

        T.solve(1);
    }

    public void solve(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                answer[cur] = Math.min(answer[cur], level);

                for (Integer next : edges.get(cur)) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }

        printAnswer();
    }

    private void printAnswer() {
        for (int i = 2; i <= N; i++) {
            String tmp = answer[i] == INF ? String.format("%d : INF", i)
                    : String.format("%d : %d", i, answer[i]);
            System.out.println(tmp);
        }
    }
}