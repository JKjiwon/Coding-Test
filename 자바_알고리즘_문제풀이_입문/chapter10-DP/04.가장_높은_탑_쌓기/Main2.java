import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N];

        int rs = 0;

        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            blocks.add(new Block(area, height, weight));
        }
        blocks.sort(Comparator.reverseOrder());

        dp[0] = blocks.get(0).height;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks.get(i).weight < blocks.get(j).weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + blocks.get(i).height;
            rs = Math.max(rs, dp[i]);
        }

        System.out.println(rs);
    }

    public static class Block implements Comparable<Block> {
        int area;
        int height;
        int weight;

        public Block(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block other) {
            return this.area - other.area;
        }
    }
}