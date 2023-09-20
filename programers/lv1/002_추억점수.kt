package programers.lv1

class Solution002 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val result = mutableListOf<Int>()
        val yearningMap = mutableMapOf<String, Int>()

        for (i in name.indices) {
            yearningMap[name[i]] = yearning[i]
        }

        for (nameArray in photo) {
            result.add(sumOfyearning(yearningMap, nameArray))
        }

        return result.toIntArray()
    }

    private fun sumOfyearning(yearningMap: MutableMap<String, Int>, nameArray: Array<String>): Int {
        var sum = 0
        for (name in nameArray) {
            val score = yearningMap.getOrDefault(name, 0)
            sum += score
        }

        return sum
    }
}