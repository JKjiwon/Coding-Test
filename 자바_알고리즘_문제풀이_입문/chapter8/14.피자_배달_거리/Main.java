import java.util.*;

/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
*/
// 조합 => 피자집 가운데 M개를 뽑아 거리 계산.
public class Main {
    static int N, M;

    static List<Point> pizza = new ArrayList<>();
    static List<Point> house = new ArrayList<>();
    static int[] selected;
    static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int point = sc.nextInt();
                if (point == 1) {
                    house.add(new Point(i, j));
                }

                if (point == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
        System.out.println(minLength);
    }

    public static void dfs(int L, int S) {
        if (L == M) {
            int sum = calLength();
            minLength = Math.min(minLength, sum);
            return;
        }

        for(int i = S; i < pizza.size(); i++) {
            selected[L] = i;
            dfs(L + 1, i + 1);
        }
    }

    private static int calLength() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                temp = Math.min(temp, house.get(i).calLength(pizza.get(selected[j])));
            }
            sum += temp;
        }

        return sum;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calLength(Point other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }
}