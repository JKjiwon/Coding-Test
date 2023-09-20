import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int count;
    static int[] dx = {0,  0, -1, 1,  -1,  -1,  1, 1};
    static int[] dy = {-1, 1,  0, 0,  -1,   1, -1,  1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}