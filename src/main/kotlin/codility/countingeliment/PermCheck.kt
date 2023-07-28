package codility.countingeliment

class PermCheck {
    fun solution(A: IntArray): Int {
        val N = A.size
        val visited = BooleanArray(N + 1)
        var count = 0

        for (num in A) {
            if (num <= N && !visited[num]) {
                visited[num] = true
                count++
            }

            if (count == N) {
                return 1
            }
        }
        return 0
    }

}
