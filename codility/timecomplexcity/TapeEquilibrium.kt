package codility.timecomplexcity

import kotlin.math.abs
import kotlin.math.min

/**
 * A.size - 2 만큼만 반복
 */
class TapeEquilibrium {
    fun solution(A: IntArray): Int {
        val sumOfAll = A.sum()
        var subSum = 0
        var answer = Int.MAX_VALUE

        for (i in 0 until A.size - 1) {
            subSum += A[i]
            answer = min(abs(sumOfAll - subSum * 2), answer)
        }
        return answer
    }
}


