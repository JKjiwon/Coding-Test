package programers.lv1

class Solution006 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var paintedStartSection = section[0]
        var count = 1

        for (nextSection in section) {
            if (paintedStartSection + m - 1 >= nextSection) {
                continue
            }
            paintedStartSection = nextSection
            count += 1
        }

        return count
    }
}