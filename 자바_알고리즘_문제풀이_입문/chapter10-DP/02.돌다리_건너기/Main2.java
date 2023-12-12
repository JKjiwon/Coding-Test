import java.util.Scanner;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 2];

        Main t = new Main();
        int rs = t.dfs(N + 1);

        System.out.println(rs);
    }

    public int dfs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dfs(n - 2) + dfs(n - 1);
    }
}