package codility.leader

class Dominator {

    fun solution(A: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for ((idx, num) in A.withIndex()) {
            map[num] = map.getOrDefault(num, 0) + 1

            if (map[num]!! > A.size / 2) {
                return idx
            }
        }
        return -1
    }
}

