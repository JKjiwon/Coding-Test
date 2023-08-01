package codility.greedy

class MaxNonoverlappingSegments {
    // A, B 모두 정렬
    fun solution(A: IntArray, B: IntArray): Int {
        val N = A.size
        if (N < 2) {
            return N
        }

        var answer = 1

        val lines = mutableListOf<Line>()
        for (i in A.indices) {
            lines.add(Line(A[i], B[i]))
        }
        lines.sort()

        var standardEnd = lines[0].end
        for (i in 1 until lines.size) {
            if (standardEnd < lines[i].start) {
                answer++
                standardEnd = lines[i].end
            }
        }
        return answer
    }

    data class Line(val start: Int, val end: Int) : Comparable<Line> {
        override fun compareTo(other: Line): Int {
            if (this.end == other.end) {
                return this.start - this.start
            } else {
                return this.end - other.end
            }
        }
    }

    // A정렬 X, B만 정렬
    fun solution2(A: IntArray, B: IntArray): Int {
        val N = A.size
        if (N < 2) {
            return N
        }

        var answer = 1

        var standardEnd = B[0]
        for (i in 1 until N) {
            if (standardEnd < A[i]) {
                answer++
                standardEnd = B[i]
            }
        }
        return answer
    }

}


fun main() {
    val result = MaxNonoverlappingSegments().solution(intArrayOf(1, 3, 7, 9, 9), intArrayOf(5, 6, 8, 9, 10))
    println(result)


}