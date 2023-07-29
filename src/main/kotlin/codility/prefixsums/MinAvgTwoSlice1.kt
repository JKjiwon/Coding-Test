package codility.prefixsums

// 무식하게 풀기
// O(N^2)
class MinAvgTwoSlice1 {
    fun solution(A: IntArray): Int {
        var minAvg = Double.MAX_VALUE
        var minIdx = 0

        for (i in A.indices) {
            var sum = A[i]
            for (j in i - 1 downTo 0) {
                sum += A[j]
                val avg = sum / (i - j + 1).toDouble()
                if (minAvg > avg) {
                    minAvg = avg
                    minIdx = j
                }
            }
        }
        return minIdx
    }
}
