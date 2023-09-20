package codility.countingeliment

class MissingInteger {
    fun solution(A: IntArray): Int {
        val aSize = A.size
        val checked = BooleanArray(aSize + 1)

        for (num in A) {
            if (num in 1 until aSize + 1) {
                checked[num] = true
            }
        }

        for (i in 1 until aSize + 1) {
            if (!checked[i]) {
                return i
            }
        }

        return aSize + 1
    }
}

