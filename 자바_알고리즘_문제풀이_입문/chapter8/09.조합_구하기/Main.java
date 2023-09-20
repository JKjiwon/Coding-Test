import java.util.*;

public class Main {
    static int N, M;
    static int[] combi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        combi = new int[M];

        dfs(0, 1);
    }

    public static void dfs(int L, int S) {
        if (L == M) {
            print();
            return;
        }
        for (int i = S; i <= N; i++) {
            combi[L] = i;
            dfs(L + 1, i + 1);
        }

    }

    private static void print() {
        for (int x : combi) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}