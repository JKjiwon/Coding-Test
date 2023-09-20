import java.util.*;

public class Main {

    static int N;
    static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dy = new int[N+1];

        dy[1] = 2;
        dy[2] = 3;

        for(int i = 3; i <= N; i++) {
            dy[i] = dy[i-1] + dy[i-2];
        }

        System.out.println(dy[N]); 
    }
}