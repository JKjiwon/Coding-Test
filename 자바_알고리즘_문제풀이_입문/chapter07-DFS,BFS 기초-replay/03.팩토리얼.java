import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(T.solve(n));
    }

    public int solve(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * solve(n - 1);
    }
    
}