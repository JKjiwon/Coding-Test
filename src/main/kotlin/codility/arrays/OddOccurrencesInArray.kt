package codility.arrays

class OddOccurrencesInArray {
    // Map
    fun solution(A: IntArray): Int {
        val aMap = mutableMapOf<Int, Int>()

        for (num in A) {
            aMap[num] = aMap.getOrDefault(num, 0) + 1
        }

        for (key in aMap.keys) {
            if (aMap[key]!! % 2 == 1) {
                return key
            }
        }

        return 0
    }

    // XOR
    fun solution2(A: IntArray): Int {
        var unpairedElement = 0

        for (num in A) {
            unpairedElement = unpairedElement xor num
        }

        return unpairedElement
    }

    // Set
    fun solution3(A: IntArray): Int {
        val set = mutableSetOf<Int>()

        for (i in A) {
            if (set.contains(i)) {
                set.remove(i)
            } else {
                set.add(i)
            }
        }
        return set.iterator().next()
    }
}
