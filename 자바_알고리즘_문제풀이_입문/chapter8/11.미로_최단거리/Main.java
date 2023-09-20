import java.util.*;
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
*/
public class Main {

    static int N = 7;
    static int M = 7;

    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) {
        visited = new boolean[N][M];
        map = new int[N][M];

        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs(0,0));
    }

    public static int bfs(int x, int y) {
        int level = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i++) {
                Point cur = q.poll();

                if (cur.x == N - 1 && cur.y == M - 1) {
                    return level;
                }
                
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}