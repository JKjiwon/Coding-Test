package codility.prefixsums

// 구간합
// O(N+M)
class GenomicRangeQuery2 {
    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
        val answer = IntArray(P.size)

        val A = IntArray(S.length)
        val C = IntArray(S.length)
        val G = IntArray(S.length)

        for (i in S.indices) {
            when (S[i]) {
                'A' -> A[i] += 1
                'C' -> C[i] += 1
                'G' -> G[i] += 1
                else -> {}
            }

            if (i == 0) {
                continue
            }

            A[i] += A[i - 1]
            C[i] += C[i - 1]
            G[i] += G[i - 1]
        }

        for (i in P.indices) {
            if (P[i] > 0) {
                if (A[Q[i]] > A[P[i] - 1]) {
                    answer[i] = 1
                } else if (C[Q[i]] > C[P[i] - 1]) {
                    answer[i] = 2
                } else if (G[Q[i]] > G[P[i] - 1]) {
                    answer[i] = 3
                } else {
                    answer[i] = 4
                }

            } else { //P[i] == 0
                if (A[Q[i]] > 0) {
                    answer[i] = 1
                } else if (C[Q[i]] > 0) {
                    answer[i] = 2
                } else if (G[Q[i]] > 0) {
                    answer[i] = 3
                } else {
                    answer[i] = 4
                }
            }
        }
        return answer
    }
}

