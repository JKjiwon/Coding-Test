import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] coins;
    static int[] dp;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        M = sc.nextInt();
        dp = new int[M+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= M; j++) {
                if (dp[j - coins[i]] != INF) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }

        System.out.println(dp[M]);
    }
}