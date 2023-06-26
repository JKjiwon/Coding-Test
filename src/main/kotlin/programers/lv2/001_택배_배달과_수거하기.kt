package programers.lv2

class Solution001 {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        deliveries.reverse()
        pickups.reverse()

        var dis = 0L
        var d = 0
        var p = 0

        for (i in 0 until n) {
            d += deliveries[i]
            p += pickups[i]

            while (d > 0 || p > 0) {
                d -= cap
                p -= cap
                dis += (n - i) * 2
            }
        }

        return dis
    }
}