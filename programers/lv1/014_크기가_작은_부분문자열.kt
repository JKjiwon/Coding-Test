package programers.lv1

// 자리수 Long 10진수 최대 18자리, Int 최대 10진수 9자리
class Solution014 {
    fun solution(t: String, p: String): Int {
        var answer = 0

        for (i in 0..(t.length - p.length)) {
            val tNum = t.substring(i, i + p.length).toLong()
            val pNum = p.toLong()
            if (tNum <= pNum) {
                answer++
            }
        }

        return answer
    }
}