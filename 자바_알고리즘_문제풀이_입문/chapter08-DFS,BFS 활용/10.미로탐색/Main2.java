import java.util.Scanner;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static final int N = 7;
    static int[][] map = new int[N][N];
    static int pathCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Main T = new Main();

        map[0][0] = 1;
        T.dfs(0, 0);

        System.out.println(pathCount);
    }

    public void dfs(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            pathCount++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                map[nx][ny] = 1;
                dfs(nx, ny);
                map[nx][ny] = 0;
            }
        }
    }
}