import java.util.*;

/*
    # 문제 풀이
    1. Map 생성: 숫자 i를 key값으로 하고, 숫자 i의 빈도를 key값으로 한다.
    2. nums를 순회하면서 Map에 값을 추가한다.
    3. 순회하면서 i 번째 수 nums[i]와 함께 k를 만드는 수가 있으면 Map에서 빈도수를 낮춘다.(제거)
*/
class Solution {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operationCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(k-nums[i], 0) > 0) {
                operationCount++;
                map.put(k-nums[i], map.get(k-nums[i]) -1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return operationCount;
    }
}