import java.util.*

// 구현 문제

// ** 주의 사항
// 코틀린에서 자바 util 사용 방법
// 맵을 사용하여 배열/리스트의 원소를 Int에서 Long으로 바꾸는 방법
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val que1 = LinkedList(queue1.map { it.toLong() })
        val que2 = LinkedList(queue2.map { it.toLong() })

        val sum = que1.sum() + que2.sum()
        if (sum % 2 == 1L) {
            return -1
        }

        val mid = sum / 2
        var count = 0
        var que1Sum = que1.sum()
        // 중간값보다 크면 빼고, 작으면 더하고
        while (true) {
            // queue 의 중간에 위치하는 값이 하나만 남으려면 큐 사이즈의 2배이상 이동해야한다.
            if (count > queue1.size * 3) {
                count = -1
                break
            }

            if (que1Sum > mid) {
                count++
                que1Sum -= que1.peek()
                que2.offer(que1.poll())
            } else if (que1Sum < mid) {
                count++
                que1Sum += que2.peek()
                que1.offer(que2.poll())
            } else {
                break
            }
        }

        return count
    }
}