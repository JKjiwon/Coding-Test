package codility.arrays

class CyclicRotation {
    fun solution(A: IntArray, K: Int): IntArray {
        val arrSize = A.size

        if (arrSize == 0 || K % arrSize == 0) {
            return A
        }

        val rotations = K % arrSize
        val rotatedArr = IntArray(arrSize)

        for (i in 0 until arrSize) {
            val rotatedIndex = (i + rotations) % arrSize
            rotatedArr[rotatedIndex] = A[i]
        }
        return rotatedArr
    }
}



