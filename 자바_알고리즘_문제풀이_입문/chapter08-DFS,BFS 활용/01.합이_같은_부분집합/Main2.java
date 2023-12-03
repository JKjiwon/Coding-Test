import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static boolean exists;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        String rs = T.solve();
        System.out.println(rs);
    }

    public String solve() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return "NO";
        }

        dfs(0, 0, sum / 2);

        return exists ? "YES" : "NO";

    }

    public void dfs(int idx, int sum, int half) {
        if (exists) {
            return;
        }

        if (idx >= N) {
            if (sum / 2 == half) {
                exists = true;
                return;
            }
        }

        dfs(idx + 1, sum + nums[idx], half);
        dfs(idx + 1, sum, half);
    }
}