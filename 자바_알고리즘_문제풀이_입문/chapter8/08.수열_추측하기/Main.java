import java.util.*;

public class Main {

    static int N, M;
    static int[] p;
    static int[] b;
    static boolean[] visited;
    static int[][] combination;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[N];
        b = new int[N];
        visited = new boolean[N + 1];
        combination = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++) {
            b[i] = com(N-1, i);
        }

        dfs(0, 0);
    }

    public static void dfs(int idx, int sum) {
        if (flag) {
            return;
        }
        
        if (idx == N) {
            if(sum == M) {
                print();
                flag = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[idx] = i;
                dfs(idx + 1, sum + p[idx] * b[idx]);
                visited[i] = false;
            }
        }
    }

    public static int com(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        if (combination[n][r] != 0) {
            return combination[n][r];
        }

        combination[n][r] = com(n - 1, r - 1) + com(n - 1, r);
        return combination[n][r];
    }

    public static void print() {
        for(int i = 0; i < N; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }
}