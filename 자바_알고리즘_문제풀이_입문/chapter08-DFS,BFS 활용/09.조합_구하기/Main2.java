import java.util.*;

public class Main {

    static int N, M;
    static int[] picks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        picks = new int[M];

        Main T = new Main();
        T.dfs(0, 1);
    }

    public void dfs(int level, int start) {
        if (level == M) {
            printPicks();
            return;
        }

        for (int i = start; i <= N; i++) {
            picks[level] = i;
            dfs(level + 1, i + 1);
        }
    }

    private void printPicks() {
        for (int i = 0; i < M; i++) {
            System.out.print(picks[i] + " ");
        }
        System.out.println();
    }
}