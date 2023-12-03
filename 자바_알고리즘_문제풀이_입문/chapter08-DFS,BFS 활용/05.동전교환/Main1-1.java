import java.util.*;
/*
A[i-k] = 금액 (i-k)를 만들 수 있는 최소한의 화폐 개수
A[i-k] 를 만들 수 있다 -> A[i] = min(A[i-k] + 1, A[i])
A[i-k] 를 만들 수 없다 -> A[i] = INF
*/
public class Main2 {
    static int N, M;
    static int[] coins;
    static int[] d;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        M = sc.nextInt();
        d = new int[M + 1];
        Arrays.fill(d, INF);
        d[0] = 0;

        Main2 t = new Main2();

        t.solution();
        System.out.println(d[M]);
    }

    public void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= M; j++) {
                if (d[j - coins[i]] != INF) {
                    d[j] = Math.min(d[j], d[j - coins[i]] + 1);
                }
            }
        }
    }
}