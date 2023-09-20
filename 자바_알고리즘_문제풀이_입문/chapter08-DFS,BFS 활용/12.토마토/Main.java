import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int unripeTomato = 0;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
                
                if (map[i][j] == 0) {
                    unripeTomato++;
                }
            }
        }
        
        int day = 0;
        if(unripeTomato == 0) {
            return 0;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            
            day++;
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        unripeTomato--;
                        q.offer(new Point(nx, ny));
                    }
                }
            }

            if (unripeTomato == 0) {
                return day;
            }
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