package programers.lv1

// 문자가 숫자인지 확인: Character.isDigit(chr)
class Solution018 {
    fun solution(s: String): Int {
        val numberMap = mapOf<String, Char>(
            "zero" to '0',
            "one" to '1',
            "two" to '2',
            "three" to '3',
            "four" to '4',
            "five" to '5',
            "six" to '6',
            "seven" to '7',
            "eight" to '8',
            "nine" to '9'
        )

        var result = ""

        var sub = ""
        for (chr in s) {
            sub += chr
            if (Character.isDigit(chr)) {
                result += sub
                sub = ""
            }
            if (numberMap.containsKey(sub)) {
                result += numberMap[sub]!!
                sub = ""
            }
        }

        return result.toInt()
    }
}