import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int INF = 987654321;
        int n = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int money = sc.nextInt();
        int[] dp = new int[money + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != INF) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[money]);
    }
}