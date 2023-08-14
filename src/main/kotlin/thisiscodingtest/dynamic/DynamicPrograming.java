package thisiscodingtest.dynamic;

public class DynamicPrograming {

    private static int[] dp = new int[101];
    private static int[] d = new int[31];

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            System.out.println(fibonacciLoop(i));
        }
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }

    public static int fibonacciLoop(int n) {
        d[1] = 1;
        d[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }
}
