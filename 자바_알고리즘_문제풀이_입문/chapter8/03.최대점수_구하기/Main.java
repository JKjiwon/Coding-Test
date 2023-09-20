import java.util.Scanner;
  
public class Main {
    static int N, M;
    static int[] scores;
    static int[] times;
    static int maxSocre;
  
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        scores = new int[N];
        times = new int[N];
        
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt(); 
        }

        Main t = new Main();
        int result = t.solution();
        System.out.println(result);
    }

    public int solution() {
        dfs(0, 0, 0);
        return maxSocre;
    }

    public void dfs(int idx, int totalTime, int totalScore) {
        if (totalTime > M) {
            return;
        }
        
        if (idx == N) {
            maxSocre = Math.max(maxSocre, totalScore);
            return;
        }

        dfs(idx + 1, totalTime + times[idx], totalScore + scores[idx]);
        dfs(idx + 1, totalTime, totalScore);
    }
}