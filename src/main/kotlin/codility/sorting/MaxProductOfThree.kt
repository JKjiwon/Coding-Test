package codility.sorting

import kotlin.math.max

// 정렬
// 양수 * 양수 * 양수
// 음수 * 음수 * 양수
class MaxProductOfThree {
    fun solution(A: IntArray): Int {
        A.sort()
        val N = A.size
        return max(A[0] * A[1] * A[N - 1], A[N - 3] * A[N - 2] * A[N - 1])
    }
}