package programers.lv1

import kotlin.math.min

class Solution007 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val result = mutableListOf<Int>()
        val keyCountMap = mutableMapOf<Char, Int>()
        for (key in keymap) {
            for ((idx, chr) in key.withIndex()) {
                val count = idx + 1
                keyCountMap[chr] = min(keyCountMap.getOrDefault(chr, 100), count)
            }
        }

        for (word in targets) {
            result.add(minCount(keyCountMap, word))
        }

        return result.toIntArray()
    }

    private fun minCount(keyCountMap: Map<Char, Int>, word: String): Int {
        var sum = 0
        for (chr in word) {
            if (!keyCountMap.containsKey(chr)) {
                return -1
            }
            sum += keyCountMap[chr]!!
        }
        return sum
    }
}