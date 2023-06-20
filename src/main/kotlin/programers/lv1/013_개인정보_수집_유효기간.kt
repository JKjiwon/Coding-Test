package programers.lv1

class Solution013 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val termMap = mutableMapOf<String, Int>()
        terms.forEach {
            val (type, term) = it.split(" ")
            termMap[type] = term.toInt()
        }

        for ((idx, privacy) in privacies.withIndex()) {
            val (privacyStartDate, type) = privacy.split(" ")
            if (parseDate(privacyStartDate).isExpired(parseDate(today), termMap[type]!!)) {
                answer.add(idx + 1)
            }
        }
        return answer.toIntArray()
    }

    private fun parseDate(strDate: String): Date {
        val tokens = strDate.split(".").map { it.toInt() }
        return Date(tokens[0], tokens[1], tokens[2])
    }
    class Date(
        val year: Int,
        val month: Int,
        val day: Int
    ) {
        fun isExpired(today: Date, monthPeriod: Int): Boolean {
            return diffDay(today) - monthPeriod * 28 >= 0
        }

        private fun diffDay(today: Date): Int {
            return today.totalDay() - this.totalDay()
        }

        private fun totalDay(): Int {
            return year * 12 * 28 + (month - 1) * 28 + day
        }
    }
}