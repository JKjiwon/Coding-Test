public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Main t = new Main();
        int n = 45;
        dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            System.out.print(t.dfs(i) + " ");
        }
    }

    public int dfs(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        if(dp[n] > 0) {
            return dp[n];
        }

        dp[n] = dfs(n-1) + dfs(n-2);
        return dp[n];
    }
}