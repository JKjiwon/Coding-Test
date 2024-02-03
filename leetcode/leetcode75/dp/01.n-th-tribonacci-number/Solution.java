/*
    # 문제 풀이
    n <= 2 일때 예외 처리
*/

class Solution {
    
    int[] dp;

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; 
        }

        return dp[n];
    }
}