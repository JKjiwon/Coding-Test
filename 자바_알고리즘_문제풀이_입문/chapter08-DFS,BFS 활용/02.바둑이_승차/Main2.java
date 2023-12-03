import java.util.*;

public class Main {

    static int N, C;
    static int[] weights;
    static int maxWeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();

        weights = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        Main T = new Main();
        T.dfs(0, 0);

        System.out.println(maxWeight);
    }

    public void dfs(int i, int sum) {
        if (sum > C) {
            return;            
        }

        if (i >= N) {
            maxWeight = Math.max(maxWeight, sum);
            return;
        }

        dfs(i + 1, sum + weights[i]);
        dfs(i + 1, sum);
    }
}