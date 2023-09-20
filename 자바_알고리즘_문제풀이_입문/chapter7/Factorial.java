public class Main {
    
    public static void main(String[] args) {
        Main t = new Main();
        int result = t.dfs(5);
        System.out.println(result);        
    }

    public int dfs(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * dfs(n-1);
    }
}