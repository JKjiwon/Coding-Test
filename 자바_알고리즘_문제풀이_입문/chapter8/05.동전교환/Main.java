import java.util.*;
  
public class Main {
    static int N, M;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder()); // 큰 금액부터 적용 -> 효율 극대화!!
        M = sc.nextInt();
        answer = M;

        Main t = new Main();

        t.dfs(0, 0, coins);
        System.out.println(answer);
    }

    public void dfs(int count, int sum, Integer[] coins) {
        if (sum > M) {
            return;
        }

        if (count >= answer) { // 동전의 개수가 업데이트한 최소값보다 크면 종료
            return;
        }

        if (sum == M) {
            answer = Math.min(answer, count);
            return;
        }

        for(int i = 0; i < N; i++) {
            dfs(count + 1, sum + coins[i], coins);
        }
    }
}