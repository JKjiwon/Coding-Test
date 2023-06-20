package programers.lv1

class Solution016 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = ""
        val scoreMap = mutableMapOf(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0,
        )

        for ((i, types) in survey.withIndex()) {
            if (choices[i] > 4) {
                scoreMap[types[1]] = scoreMap.getOrDefault(types[1], 0) + choices[i] - 4
            } else if (choices[i] < 4) {
                scoreMap[types[0]] = scoreMap.getOrDefault(types[0], 0) + 4 - choices[i]
            }
        }

        if (scoreMap['R']!! >= scoreMap['T']!!) {
            answer += 'R'
        } else {
            answer += 'T'
        }

        if (scoreMap['C']!! >= scoreMap['F']!!) {
            answer += 'C'
        } else {
            answer += 'F'
        }

        if (scoreMap['J']!! >= scoreMap['M']!!) {
            answer += 'J'
        } else {
            answer += 'M'
        }

        if (scoreMap['A']!! >= scoreMap['N']!!) {
            answer += 'A'
        } else {
            answer += 'N'
        }

        return answer
    }
}