public class Main {
    static int N, M;
    static int[] result;

    public static void main(String[] args) {
        Main t = new Main();
        N = 3;
        M = 2;
        result = new int[M];

        t.dfs(0);
    }

    public void dfs(int idx) {
        if (idx == M) {
            print();
            return;
        } 

        for (int i = 1; i <= N; i++) {
            result[idx] = i;
            dfs(idx + 1);
        }
    }

    public void print() {
        for(int i = 0; i < M; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}