package thisiscodingtest.dynamic;

import java.util.Arrays;
import java.util.Scanner;
/*
3 4
3
5
7
 */

/**
 * 화폐의 모든 경우의 수를 살피는게 중요(1 ~ M)
 * <p>
 * 화폐의 종류: N(1 <= N <= 100)
 * 화폐를 가지고 만들고자 하는 금액: M(1 <= M <= 10000)
 * <p>
 * 금액 i를 만들 수 있는 화폐의 최소 개수: A(i)
 * 화폐의 구성: k
 * <p>
 * A(i-k)를 만들 수 있을 때: A(i) = min(A(i), A(i-K)+1)
 * A(i-k)를 만들 수 없을 때: 10001
 * <p>
 * 시간 복잡도 O(N*M)
 */
public class Sol5 {
    static int N = 0;
    static int M = 0;
    static int[] coins;
    static int[] money;
    static int INF = 10001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(solution());
    }

    public static int solution() {
        money = new int[M + 1];
        Arrays.fill(money, INF);

        money[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= M; i++) {
                if (money[i - coin] != INF) {
                    money[i] = Math.min(money[i], money[i - coin] + 1);
                }
            }
        }
        return money[M] != INF ? money[M] : -1;
    }
}
