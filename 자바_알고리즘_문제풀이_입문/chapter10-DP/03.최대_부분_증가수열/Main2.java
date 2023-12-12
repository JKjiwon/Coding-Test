import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] dp = new int[N]; // i번째항을 마지막으로하는 최대 부분 증가 수열의 길이

        int rs = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            rs = Math.max(rs, dp[i]);
        }
        System.out.println(rs);
    }
}