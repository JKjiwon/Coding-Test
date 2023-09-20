package thisiscodingtest.dynamic;

import java.util.Scanner;

/*
재귀로 할시 stackOverFlow 발생
java 실행 옵션 변경(스택 사이즈 변경) ->  -Xss10m
 */
public class Sol1 {
    static int[] dp;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp = new int[N + 1];
        d = new int[N + 1];

        System.out.println(toOneLoop(N));
        System.out.println(toOne(N));
    }

    public static int toOne(int n) {
        if (n == 1) {
            return 0;
        }

        if (dp[n] > 0) {
            return dp[n];
        }
        int count = 30001;
        if (n % 5 == 0) {
            count = Math.min(toOne(n / 5), count);
        }
        if (n % 3 == 0) {
            count = Math.min(toOne(n / 3), count);
        }
        if (n % 2 == 0) {
            count = Math.min(toOne(n / 2), count);
        }

        count = Math.min(toOne(n - 1), count);
        dp[n] = count + 1;

        return dp[n];
    }

    public static int toOneLoop(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }
        return d[n];
    }
}
