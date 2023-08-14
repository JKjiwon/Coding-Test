package thisiscodingtest.greedy;

import java.util.Scanner;

public class Sol4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int count = 0;

        while (N != 1) {
            count++;
            if (N % K == 0) {
                N /= K;
            } else {
                N -= 1;
            }
        }

        System.out.println(count);
    }
}
