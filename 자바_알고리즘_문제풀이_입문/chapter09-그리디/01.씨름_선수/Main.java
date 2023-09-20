import java.util.*;

// Array 정렬 -> Arrays.sort(arr);
// List 정렬 -> Collections.sort();

public class Main {
    static int N;
    static Person[] persons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        persons = new Person[N];

        for (int i = 0; i < N; i++) {
            persons[i] = new Person(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(persons);


        int maxWeight = persons[0].weight;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (persons[i].weight > maxWeight) {
                answer++;
                maxWeight = persons[i].weight;
            }
        }

        System.out.println(answer);
    }

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person other) {
            return other.height - this.height;
        }
    }
}