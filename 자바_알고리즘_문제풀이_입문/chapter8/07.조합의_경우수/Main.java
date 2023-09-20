import java.util.*;

public class Main {

    static int N, R;
    static int[][] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();

        ch = new int[N + 1][R + 1];
        
        System.out.println(combination(N, R));
    }

    public static int combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        
        if (ch[n][r] != 0) {
            return ch[n][r];
        }

        ch[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        return ch[n][r];
    }
}