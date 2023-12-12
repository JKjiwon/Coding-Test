import java.util.*;

public class Main {

    static int N;    
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 1];

        Main T = new Main();

        int rs = T.solve(N);

        System.out.println(rs);
    }

    public int solve(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return solve(n - 2) + solve(n - 1);
    }
}  