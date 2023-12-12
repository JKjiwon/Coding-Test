import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] scores = new int[N + 1];
        int[] times = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        int rs1 = solve1(N, M, scores, times);
        int rs2 = solve2(N, M, scores, times);

        System.out.println(rs1);
        System.out.println(rs2);
    }

    public static int solve1(int n, int m, int[] scores, int[] times) {
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - times[i]] + scores[i]);
            }
        }

        return dp[m];
    }

    public static int solve2(int n, int m, int[] scores, int[] times) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < times[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + scores[i]);
                }
            }
        }
        return dp[n][m];
    }
}