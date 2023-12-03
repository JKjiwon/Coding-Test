import java.util.*;

public class Main {

    static int N;
    static Integer[] coins;
    static int money;

    static int minCoinCnt = 501;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        
        Arrays.sort(coins, Collections.reverseOrder()); // 큰 금액부터 적용 -> 효율 극대화!!

        money = sc.nextInt();

        Main T = new Main();
        T.dfs(0, 0);

        System.out.println(minCoinCnt);
    }

    public void dfs(int cnt, int sum) {
        if (sum > money) {
            return;
        }

        if (cnt > minCoinCnt) {
            return;
        }

        if (sum == money) {
            minCoinCnt = Math.min(minCoinCnt, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            dfs(cnt + 1, sum + coins[i]);
        }
    }
}