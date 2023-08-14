package thisiscodingtest.greedy;

import java.util.Scanner;

/**
 * 각 행의 최소값 중에서 최대값 찾기.
 * 시간복잡도: O(N*M)
 */
public class Sol3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] cards = new int[N][M];

        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            int minValue = 10001;
            for (int j = 0; j < M; j++) {
                cards[i][j] = scanner.nextInt();
                minValue = Math.min(minValue, cards[i][j]);
            }
            maxValue = Math.max(maxValue, minValue);
        }

        System.out.println(maxValue);
    }
}
