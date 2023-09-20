import java.util.*;

public class Main {
    static int N, M;
    static Quiz[] quizzes;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        dp = new int[N+1][M+1];
        quizzes = new Quiz[N+1];

        for (int i = 1; i <= N; i++) {
            quizzes[i] = new Quiz(sc.nextInt(), sc.nextInt());
        }

        for (int i = 1; i <= N; i++) { // Nth quiz
            for (int j = 1; j <= M; j++) { // limitTime
                Quiz quiz = quizzes[i];
                if (quiz.limit > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - quiz.limit] + quiz.score);
                }
            }
        }

        System.out.println(dp[N][M]);
    }

    static class Quiz {
        public int score;
        public int limit;

        public Quiz(int score, int limit) {
            this.score = score;
            this.limit = limit;
        }
    }
}