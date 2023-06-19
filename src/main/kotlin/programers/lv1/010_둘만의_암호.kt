package programers.lv1

class Solution010 {
    fun solution(s: String, skip: String, index: Int): String {
        var answer = ""
        val alphabets = ('a'..'z').filter { it !in skip }

        s.forEach {
            var chrIdx = (alphabets.indexOf(it) + index) % alphabets.size
            answer += alphabets[chrIdx]
        }

        return answer
    }
}