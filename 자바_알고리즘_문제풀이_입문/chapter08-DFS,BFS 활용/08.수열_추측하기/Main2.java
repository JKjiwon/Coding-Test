import java.util.Scanner;

public class Main {

    static int N, F;
    static int[] top;
    static int[][] combi;
    static boolean[] picks;
    static boolean find;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        F = sc.nextInt();

        top = new int[N];
        picks = new boolean[N + 1];
        combi = new int[N][N];

        Main T = new Main();

        T.solve();
    }

    public void solve() {
        // combi: (n-1)C0 ~ (n-1)C(n-1)
        for (int i = 0; i < N; i++) {
            calCombi(N - 1, i);
        }

        // top[i] * combi[i]
        dfs(0, 0);
    }

    private void printTop() {
        for (int i = 0; i < N; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
    }

    private int calCombi(int n, int r) {
        if (n == r || r == 0) {
            combi[n][r] = 1;
            return combi[n][r];
        }

        if (combi[n][r] != 0) {
            return combi[n][r];
        }

        combi[n][r] = calCombi(n - 1, r - 1) + calCombi(n - 1, r);

        return combi[n][r];
    }

    private void dfs(int idx, int sum) {
        if (find) {
            return;
        }
        if (sum > F) {
            return;
        }

        if (idx >= N) {
            if (sum == F) {
                printTop();
                find = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!picks[i]) {
                picks[i] = true;
                top[idx] = i;
                dfs(idx + 1, sum + top[idx] * combi[N - 1][idx]);
                picks[i] = false;
            }
        }
    }
}