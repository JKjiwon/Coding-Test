public class Main {
    
    public static void main(String[] args) {
        Main t = new Main();
        t.dfs(11);
    }

    public void dfs(int n) {
        if(n == 0) {
            return;
        }
        dfs(n/2);
        System.out.print(n % 2);
    }
}