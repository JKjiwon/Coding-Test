package codility.countingeliment

class FrogRiverOne {
    fun solution(X: Int, A: IntArray): Int {
        val visited = BooleanArray(X + 1)
        var count = 0

        for (i in A.indices) {
            if (!visited[A[i]]) {
                visited[A[i]] = true
                count++
            }
            if (count == X) {
                return i
            }
        }
        return -1
    }
}
