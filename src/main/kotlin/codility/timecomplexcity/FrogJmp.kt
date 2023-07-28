package codility.timecomplexcity

class FrogJmp {
    fun solution(X: Int, Y: Int, D: Int): Int {
        val moveDist = Y - X
        val moveCount = moveDist / D

        if (moveCount * D < moveDist) {
            return moveCount + 1
        }

        return moveCount
    }
}
