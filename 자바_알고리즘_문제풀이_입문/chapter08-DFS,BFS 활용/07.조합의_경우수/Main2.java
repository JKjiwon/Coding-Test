import java.util.*;

public class Main {

    static int N, R;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();

        dp = new int[N + 1][N + 1];

        Main T = new Main();

        int rs = T.combination(N, R);
        System.out.println(rs);
    }

    public int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        return dp[n][r];
    }
}