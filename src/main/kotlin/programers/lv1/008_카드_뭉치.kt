package programers.lv1

class Solution008 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var idx1 = 0
        var idx2 = 0

        for (word in goal) {
            if (idx1 < cards1.size && cards1[idx1] == word) {
                idx1++
            } else if (idx2 < cards2.size && cards2[idx2] == word) {
                idx2++
            } else {
                return "No"
            }
        }
        return "Yes"
    }
}
