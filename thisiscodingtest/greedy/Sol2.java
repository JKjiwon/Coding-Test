package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
5 8 3
2 4 5 4 6
 */
public class Sol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        Integer[] numbers = new Integer[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = sol2(M, K, numbers);
        System.out.println(sum);
    }

    private static int sol1(int M, int K, Integer[] numbers) {
        Arrays.sort(numbers, Comparator.reverseOrder());
        int sum = 0;
        int count = 0;

        for (int i = 0; i < M; i++) {
            if (count == K) {
                sum += numbers[1];
                count = 0;
            } else {
                sum += numbers[0];
                count++;
            }
        }
        return sum;
    }

    private static int sol2(int M, int K, Integer[] numbers) {
        Arrays.sort(numbers, Comparator.reverseOrder());

        int count = M / (K + 1) * K;
        count += M % (K + 1);

        return count * numbers[0] + (M - count) * numbers[1];
    }
}
