import java.util.*;

public class Main {

    public static int n;
    public static boolean[] visited;

    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        T.solve(n);
    }

    public void solve(int n) {
        visited = new boolean[n + 1];
        dfs(1);
    }

    private void dfs(int idx) {
        if (idx > n) {
            print();
            return;
        }

        visited[idx] = true;
        dfs(idx + 1);
        visited[idx] = false;
        dfs(idx + 1);
    }

    private void print() {
        String result = "";
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                result += i + " ";
            }
        }
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }
}