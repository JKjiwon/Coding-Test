import java.util.*;

public class Main {
    static int N;
    static List<Time> times = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            times.add(new Time(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(times);

        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (endTime <= times.get(i).start) {
                answer++;
                endTime = times.get(i).end;
            }
        }

        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }
}