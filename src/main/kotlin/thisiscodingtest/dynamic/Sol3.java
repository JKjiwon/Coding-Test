package thisiscodingtest.dynamic;

import java.util.Scanner;

public class Sol3 {
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        d = new int[N + 1];
        System.out.println(fillTile(N));

    }
    private static int fillTile(int N) {
        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <= N; i++) {
            d[i] = d[i - 1] + d[i - 2] * 2;
        }

        return d[N];
    }
}
