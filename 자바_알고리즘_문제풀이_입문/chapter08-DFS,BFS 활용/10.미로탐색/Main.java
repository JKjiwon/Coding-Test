import java.util.*;

public class Main {

    static int N = 7;
    static int M = 7;

    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count;

    public static void main(String[] args) {
        visited = new boolean[N][M];
        map = new int[N][M];

        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        visited[0][0] = true;
        dfs(0,0);

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        if (x == N - 1 && y == M -1) {
            count++;
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}