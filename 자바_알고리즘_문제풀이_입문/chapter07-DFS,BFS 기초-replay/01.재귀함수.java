import java.lang.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        T.solve(n);
    }

    public void solve(int n) {
        if (n < 1) {
            return;
        }
        solve(n - 1);
        System.out.print(n + " ");
    }
}