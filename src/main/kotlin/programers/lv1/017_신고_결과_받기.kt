package programers.lv1

class Solution017 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = mutableListOf<Int>()
        val reportCountMap = mutableMapOf<String, Int>()
        val reportMap = mutableMapOf<String, MutableList<String>>()

        for (id in id_list) {
            reportMap[id] = mutableListOf<String>()
        }

        for (rp in setOf(*report)) {
            val (from, to) = rp.split(" ")
            reportCountMap[to] = reportCountMap.getOrDefault(to, 0) + 1
            reportMap[from]!!.add(to)
        }

        for (id in id_list) {
            var count = 0
            for (name in reportMap[id]!!) {
                if (reportCountMap.getOrDefault(name, 0) >= k) count++
            }
            answer.add(count)
        }

        return answer.toIntArray()
    }
}