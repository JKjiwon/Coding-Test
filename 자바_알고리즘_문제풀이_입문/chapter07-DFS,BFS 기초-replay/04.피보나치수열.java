import java.util.*;

public class Main {
    public static int[] dp;

    public static void main(String[] args) {
        Main T = new Main();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print(T.solve(i) + " ");
        }
    }

    public int solve(int n) {
        if (n <= 2) {
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }
}