package codility.prefixsums

/**
 * (a, b)의 평균: a <= b -> 평균은 a 이상
 * (a, b, c, d)의 평군: (a+b) <= (c+d) -> 평균은 (a+b) 이상
 * (a, b, c) 의 평균: (a, b), c의 평균을 비교해야 함 -> 하지만 원소 1개의 평균은 문제의 조건에 맞지 않으므로 3개가 한 묶음이 된다.
 * 원소 2 이거나 3 일때의 평균을 구하면, 최소 평균의 index값을 구할 수있다.
 */
class MinAvgTwoSlice2 {
    fun solution(A: IntArray): Int {
        var minAvg = (A[0] + A[1]) / 2.0
        var minIdx = 0

        for (i in 2 until A.size) {
            var avg = (A[i - 1] + A[i]) / 2.0
            if (avg < minAvg) {
                minAvg = avg
                minIdx = i - 1
            }

            avg = (A[i - 2] + A[i - 1] + A[i]) / 3.0
            if (avg < minAvg) {
                minAvg = avg
                minIdx = i - 2
            }
        }

        return minIdx
    }
}
