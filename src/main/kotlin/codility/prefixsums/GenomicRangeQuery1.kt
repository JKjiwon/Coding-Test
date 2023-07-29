package codility.prefixsums

import kotlin.math.min

// O(N*M)
// 시간복잡도 개선 필요!!
class GenomicRangeQuery1 {
    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
        val dnaType = mutableMapOf(
            'A' to 1,
            'C' to 2,
            'G' to 3,
            'T' to 4
        )

        val answer = IntArray(P.size)

        for (i in P.indices) {
            val subSequence = S.substring(P[i], Q[i] + 1)
            answer[i] = minFactor(dnaType, subSequence)
        }

        return answer
    }

    fun minFactor(dnaType: Map<Char, Int>, subSequence: String): Int {
        var answer = 5
        for (dna in subSequence) {
            answer = min(answer, dnaType[dna]!!)
        }
        return answer
    }
}
