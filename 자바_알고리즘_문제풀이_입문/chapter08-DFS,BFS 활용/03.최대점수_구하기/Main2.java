import java.util.*;

public class Main {

    static int N, M;
    static int[] scores;
    static int[] times;

    static int maxTotalScore;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        scores = new int[N];
        times = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        Main T = new Main();

        T.dfs(0, 0, 0);

        System.out.println(maxTotalScore);
    }

    public void dfs(int i, int time, int score) {
        if (time > M) {
            return;
        }

        if (i >= N) {
            maxTotalScore = Math.max(maxTotalScore, score);
            return;
        }

        dfs(i + 1, time + times[i], score + scores[i]);
        dfs(i + 1, time, score);
    }

}