public class Main {

    public static void main(String[] args) {
        Main t = new Main();
        int n = 45;

        for(int i = 1; i <= n; i++) {
            System.out.print(t.dfs(i) + " ");
        }
    }

    public int dfs(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }

        return dfs(n-1) + dfs(n-2);
    }
}