import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static final int N = 7;
    static int[][] map = new int[N][N];
    static boolean[][] visited = new boolean[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Main T = new Main();
        int rs = T.bfs(0, 0);

        System.out.println(rs);
    }

    public int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N
                        && map[nx][ny] == 0 && !visited[nx][ny]) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return map[N - 1][N - 1] != 0 ? map[N - 1][N - 1] : -1;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}