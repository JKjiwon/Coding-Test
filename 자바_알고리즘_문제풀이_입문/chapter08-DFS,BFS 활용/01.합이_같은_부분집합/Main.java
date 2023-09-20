import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int totalSum = 0;
    static String answer = "NO";
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            totalSum += arr[i];
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int sum) {
        if (flag) {
            return;
        }

        if (sum * 2 > totalSum) {
            return;
        }

        if (idx == N) {
            if (sum * 2 == totalSum) {
                answer = "YES";
                flag = true;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}