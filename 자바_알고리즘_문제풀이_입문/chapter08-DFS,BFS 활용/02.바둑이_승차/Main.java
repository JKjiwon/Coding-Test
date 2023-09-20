import java.util.Scanner;

public class Main {
    static int totalSum, N, M = 0;
    static int[] dogs;
    static int maxWeigth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        dogs = new int[N];
        for (int i = 0; i < N; i++) {
            dogs[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(maxWeigth);
    }

    public static void dfs(int idx, int sum) {
        if (sum > M) {
            return;
        }

        if (idx == N) {
            maxWeigth = Math.max(maxWeigth, sum);
            return;
        }

        dfs(idx + 1, sum + dogs[idx]);
        dfs(idx + 1, sum);
    }
}