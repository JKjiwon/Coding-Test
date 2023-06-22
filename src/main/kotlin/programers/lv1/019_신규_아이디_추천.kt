package programers.lv1

// 정규 표현식
class Solution019 {
    fun solution(new_id: String): String {
        var answer = new_id
        // 1단계
        answer = answer.toLowerCase()
        // 2단계
        answer = answer.replace("[^a-z0-9-_.]".toRegex(), "")
        // 3단계
        answer = answer.replace("\\.{2,}".toRegex(), ".")
        // 4단계
        answer = answer.replace("^\\.|\\.$".toRegex(), "")
        // 5단계
        if (answer == "") answer = "a"
        // 6단계
        if (answer.length >= 16) answer = answer.substring(0, 15).replace("\\.$".toRegex(), "")
        // 7단계
        if (answer.length <= 2) {
            val len = answer.length
            val lastChar = answer[answer.length - 1]
            for (i in len until 3) {
                answer += lastChar
            }
        }
        return answer
    }
}