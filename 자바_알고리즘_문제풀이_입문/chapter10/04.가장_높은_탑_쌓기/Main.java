import java.util.*;

// 벽돌을 쌓는 순서가 정해져 있지 않으므로
// 최대로 많이 쌓으러면 벽돌를 쌓는 순서를 재배치해야한다.
public class Main {

    static int N;
    static int[] dp;
    static Brick[] bricks;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N];
        bricks = new Brick[N];

        for (int i = 0; i < N; i++) {
            bricks[i] = new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(bricks);

        dp[0] = bricks[0].height;
        int maxHeight = dp[0];
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (bricks[i].weight < bricks[j].weight) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + bricks[i].height;
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        System.out.println(maxHeight);
    }

    static class Brick implements Comparable<Brick> {
        public int area;
        public int height;
        public int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick other) {
            return other.area - this.area;
        }
    }
}