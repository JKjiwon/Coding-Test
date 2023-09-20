import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[M+1];

        for (int i = 0; i < N; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for (int j = M; j >= pt; j--) {
                dp[j] = Math.max(dp[j], dp[j-pt]+ps);
            }
        }

        System.out.println(dp[M]);
    }
}