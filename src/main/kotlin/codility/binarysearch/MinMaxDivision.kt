package codility.binarysearch

class MinMaxDivision {

    fun solution(K: Int, M: Int, A: IntArray): Int {
        var lowerBound = A.maxOrNull()!!
        var upperBound = M * A.size

        while (lowerBound <= upperBound) {
            val mid = (lowerBound + upperBound) / 2
            if (isPossible(K, mid, A)) {
                upperBound = mid - 1
            } else {
                lowerBound = mid + 1
            }
        }

        return lowerBound
    }

    // 원소의 합이 maxSum를 넘어가지 않고, block이 K를 넘어가지 않는 값을 구할 수 있는지 확인.
    private fun isPossible(K: Int, maxSum: Int, A: IntArray): Boolean {
        var blockSum = 0
        var blockCount = 1

        for (num in A) {
            if (blockSum + num > maxSum) {
                blockSum = num
                blockCount++
            } else {
                blockSum += num
            }

            if (blockCount > K) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = MinMaxDivision().solution(3, 5, intArrayOf(2, 1, 5, 1, 2, 2, 2))
    println(solution)

}