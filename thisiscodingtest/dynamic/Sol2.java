package thisiscodingtest.dynamic;

import java.util.Scanner;
// n번째 값이 K일때
// A(n) = max(A(n-1), A(n-2) + K)
public class Sol2 {
    static int N;
    static int[] area;
    static int[] dp;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        area = new int[N];
        dp = new int[N];
        d = new int[N];
        for (int i = 0; i < N; i++) {
            area[i] = scanner.nextInt();
        }
        System.out.println(stillFood(N - 1));
        System.out.println(stillFoodInLoop(N - 1));
    }

    private static int stillFood(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }

        if (n == 0) {
            dp[0] = area[0];
            return dp[0];
        }

        if (n == 1) {
            dp[1] = Math.max(area[0], area[1]);
            return dp[1];
        }

        dp[n] = Math.max(stillFood(n - 1), stillFood(n - 2) + area[n]);
        return dp[n];
    }

    private static int stillFoodInLoop(int n) {
        d[0] = area[0];
        d[1] = Math.max(area[0], area[1]);

        for (int i = 2; i <= n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + area[i]);
        }

        return d[n];
    }
}
