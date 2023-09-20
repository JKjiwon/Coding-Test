package codility.prefixsums

class CountDiv {
    fun solution(A: Int, B: Int, K: Int): Int {
        var cnt = B / K - A / K

        if (A % K == 0) {
            cnt++
        }
        return cnt
    }
}
