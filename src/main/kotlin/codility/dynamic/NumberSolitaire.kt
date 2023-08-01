package codility.dynamic

import kotlin.math.max

// score[i]: i까지의 최대 score
class NumberSolitaire {
    fun solution(A: IntArray): Int {
        val score = IntArray(A.size)
        score[0] = A[0]

        for (i in 1 until score.size) {
            var maxValue = Int.MIN_VALUE
            val pre = if (i - 6 < 0) 0 else i - 6

            for (j in pre until i) {
                maxValue = max(score[j] + A[i], maxValue)
            }
            score[i] = maxValue
        }

        return score[score.size - 1]
    }
}

fun main() {
    val result = NumberSolitaire().solution(intArrayOf(1, -2, 0, 9, -1, -2))
    println(result)
}
