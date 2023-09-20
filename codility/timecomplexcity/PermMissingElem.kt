package codility.timecomplexcity

class PermMissingElem {
    fun solution(A: IntArray): Int {
        val checkArr = BooleanArray(A.size + 2)

        for (num in A) {
            checkArr[num] = true
        }

        for (i in 1 until checkArr.size) {
            if (!checkArr[i]) {
                return i
            }
        }
        return 0
    }

    fun solution2(A: IntArray): Int {
        val sumToN = (A.size + 1).toLong() * (A.size + 2) / 2
        return (sumToN - A.sumOf { it.toLong() }).toInt()
    }
}
