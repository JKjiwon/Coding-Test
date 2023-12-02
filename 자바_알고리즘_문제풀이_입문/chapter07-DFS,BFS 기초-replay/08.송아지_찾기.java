import java.util.*;

public class Main {

    public static int S, E;
    public static int[] dis = {1, -1, 5};
    public static boolean[] visited = new boolean[10001];

    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        S = in.nextInt();
        E = in.nextInt();

        int rs = T.solve(S, E);

        System.out.println(rs);
    }

    public int solve(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                if (cur == e) {
                    return level;
                }
                
                /*
                # 최적화
                - 좌표 점은 1 ~ 10000
                - 방문한 좌표 점은 다시 방문하지 않는다.
                 */
                for (int j = 0; j < 3; j++) {
                    int next = cur + dis[j];
                    if (next < 1 || next > 10000 || visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    q.offer(next);
                }
            }

            level++;
        }
        
        return 0;
    }
}