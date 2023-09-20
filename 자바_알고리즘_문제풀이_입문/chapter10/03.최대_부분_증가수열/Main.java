import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}