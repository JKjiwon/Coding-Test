// Stack = 매개변수 + 지역변수 + 복귀주소

public class Main {
    
    public static void main(String[] args) {
        Main t = new Main();
        t.dfs(3);
    }

    public void dfs(int n) {
        if (n == 0) {
            return;
        }
        dfs(n - 1);
        System.out.println(n);
    }
}
