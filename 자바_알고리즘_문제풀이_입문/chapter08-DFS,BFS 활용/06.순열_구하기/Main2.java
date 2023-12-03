import java.util.*;

public class Main {

    static int N, M;
    static int[] nums, answer;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        visited = new boolean[N];

        answer = new int[M];

        Main T = new Main();

        T.dfs(0);
    }

    public void dfs(int cnt) {
        if (cnt == M) {
            printNums();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[cnt] = nums[i];
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private void printNums() {
        for (int i = 0; i < M; i++) {
            System.out.printf("%d ", answer[i]);
        }
        System.out.println();
    }
}