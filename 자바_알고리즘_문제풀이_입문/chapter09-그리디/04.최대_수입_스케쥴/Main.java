import java.util.*;

// PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] moneys = new int[n];
        int[] dates = new int[n];

        for (int i = 0; i < n; i++) {
            moneys[i] = sc.nextInt();
            dates[i] = sc.nextInt();
        }

        Main test = new Main();
        int result = test.solution(moneys, dates, n);

        System.out.println(result);
    }

    public int solution(int[] moneys, int[] dates, int n) {
        int maxdate = 0;
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lectures.add(new Lecture(moneys[i], dates[i]));
            maxdate = Math.max(dates[i], maxdate);
        }
        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int totalMoney = 0;
        int j = 0;
        for (int i = maxdate; i >= 1; i--) {
            // i번째 날에 할 수 있는 강의를 우선순위 큐에 넣는다.
            for (; j < n; j++) {
                if (lectures.get(j).date < i) {
                    break;
                }
                pq.offer(lectures.get(j).money);
            }
            // i번째 날에 할 수 있는 강의 중 금액이 가장 큰 강의를 우선순위 큐에서 뺀다.
            if (!pq.isEmpty()) {
                totalMoney += pq.poll();
            }
        }
        return totalMoney;
    }

    static class Lecture implements Comparable<Lecture> {
        int money;
        int date;

        public Lecture(int money, int date) {
            this.money = money;
            this.date = date;
        }

        public int compareTo(Lecture other) {
            return other.date - this.date;
        }
    }
}