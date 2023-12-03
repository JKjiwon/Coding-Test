import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[M];

        Main T = new Main();
        T.dfs(0);
    }

    public void dfs(int i) {
        if (i >= M) {
            printNums();
            return;
        }

        for (int num = 1; num <= N; num++) {
            nums[i] = num;
            dfs(i + 1);
        }
    }

    private void printNums() {
        for (int i = 0; i < M; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }
}