import java.util.*;

class Main {
    
    static int[] jump = {1, -1, 5};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        Main t = new Main();
        int result = t.solution(n, m);
        System.out.println(result);
    }
    
    public int solution(int n, int m) {
        int level = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == m) {
                    return level;
                }
                for(int j = 0; j < jump.length; j++) {
                    queue.offer(cur + jump[j]);
                }
            }
            level++;
        }
        return 0;
    }
}