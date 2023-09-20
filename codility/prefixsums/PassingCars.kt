package codility.prefixsums

class PassingCars {
    fun solution(A: IntArray): Int {
        var zeroCount = 0
        var sum = 0

        for (num in A) {
            if (num == 0) {
                zeroCount++
            } else {
                sum += zeroCount
            }

            if (sum > 1_000_000_000) {
                return -1
            }
        }
        return sum
    }
}




