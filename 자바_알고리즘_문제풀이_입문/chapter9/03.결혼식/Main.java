import java.util.*;

public class Main {

    static int N;
    static List<Time> times = new ArrayList<>();
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            times.add(new Time(sc.nextInt(), "s"));
            times.add(new Time(sc.nextInt(), "e"));
        }

        Collections.sort(times);

        int answer = 0;
        int count = 0;
        for (Time time : times) {
            if (time.status.equals("s")) {
                count++;
            } else {
                count--;
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        int hour;
        String status;

        public Time(int hour, String status) {
            this.hour = hour;
            this.status = status;
        }

        @Override
        public int compareTo(Time other) {
            if (this.hour == other.hour) {
                return this.status.compareTo(other.status);
            }
            return this.hour - other.hour;
        }
    }

}