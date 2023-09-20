import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        visited = new boolean[N];
        result = new int[M];

        Main t = new Main();
        t.dfs(0);
    }

    public void dfs(int idx) {
        if (idx == M) {
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }

    public void print() {
        for(int i = 0; i < M; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
