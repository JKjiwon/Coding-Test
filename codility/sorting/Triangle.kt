package codility.sorting

// 삼각형의 조건
// 가장 긴변이 나머지 두변의 길이의 합 보다 작아야 한다.
// Int 더하기의 Overflow 고려
class Triangle {
    fun solution(A: IntArray): Int {
        val n = A.size
        A.sort()
        for (i in 0 until n - 2) {
            if (A[i].toLong() + A[i + 1].toLong() > A[i + 2]) {
                return 1
            }
        }
        return 0
    }
}