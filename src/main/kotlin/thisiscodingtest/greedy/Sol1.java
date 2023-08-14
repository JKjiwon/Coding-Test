package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 정당성 검토가 중요하다.
 * 가지고 있는 동전 중에서 큰 단위가 항상 작은 단위의 배수 -> 작은 단위으 동전들을 종합해 다른 해가 나올 수 없다.
 */
public class Sol1 {
    public static void main(String[] args) {
        int money = 1260;
        int[] coins = {10, 50, 100, 500};
        int count = 0;
        coins = Arrays.stream(coins)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        for (int coin : coins) {
            count += money / coin;
            money %= coin;
        }
        System.out.println(count);
    }
}
