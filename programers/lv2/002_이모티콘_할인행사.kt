package programers.lv2

import kotlin.math.max

// 백트래킹을 이용한 할인율의 모든 경우의 수 나열
class Solution002 {
    val ans = IntArray(2) { 0 }

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        dfs(IntArray(emoticons.size) { 0 }, users, emoticons, 0)
        return ans
    }

    fun dfs(discountRate: IntArray, users: Array<IntArray>, emoticons: IntArray, idx: Int) {
        if (idx > emoticons.size - 1) {
            cal(discountRate, users, emoticons)
            return
        }

        for (rate in arrayOf(10, 20, 30, 40)) {
            discountRate[idx] = rate
            dfs(discountRate, users, emoticons, idx + 1)
        }
    }

    fun cal(discountRate: IntArray, users: Array<IntArray>, emoticons: IntArray) {
        var plus = 0
        var sum = 0
        for (user in users) {
            var userSum = 0
            for ((i, emoticon) in emoticons.withIndex()) {
                if (discountRate[i] >= user[0]) {
                    userSum += emoticon * (100 - discountRate[i]) / 100
                }
            }
            if (userSum >= user[1]) {
                plus++
            } else {
                sum += userSum
            }
        }
        if (plus > ans[0]) {
            ans[0] = plus
            ans[1] = sum
        } else if (plus == ans[0]) {
            ans[1] = max(ans[1], sum)
        }
    }
}