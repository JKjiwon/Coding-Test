package codility.greedy

class TieRopes {

    fun solution(K: Int, A: IntArray): Int {
        var sum = 0L
        var answer = 0

        for (rope in A) {
            sum += rope
            if (sum >= K) {
                answer++
                sum = 0
            }
        }
        return answer
    }
}

