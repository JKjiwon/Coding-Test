package codility.countingeliment

import kotlin.math.max

// 모든 배열 값을 max 값으로 어떻게 바꿀 것인가? -> 시간 복잡도 고려
class MaxCounters {
    fun solution(N: Int, A: IntArray): IntArray {
        val answer = IntArray(N)
        var curMax = 0
        var baseMax = 0

        for (x in A) {
            if (x == N + 1) {
                baseMax = curMax
            } else {
                answer[x - 1] = max(baseMax, answer[x - 1]) + 1
                curMax = max(curMax, answer[x - 1])
            }
        }

        for (i in answer.indices) {
            answer[i] = max(answer[i], baseMax)
        }
        return answer
    }
}
