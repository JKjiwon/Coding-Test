package programers.lv1

import kotlin.math.max
import kotlin.math.min

class Solution005 {
    fun solution(wallpaper: Array<String>): IntArray {
        var (xMin, yMin) = 50 to 50
        var (xMax, yMax) = 0 to 0

        for ((x, line) in wallpaper.withIndex()) {
            for (y in line.indices) {
                if (wallpaper[x][y] == '#') {
                    xMin = min(x, xMin)
                    yMin = min(y, yMin)
                    xMax = max(x, xMax)
                    yMax = max(y, yMax)
                }
            }
        }
        return intArrayOf(xMin, yMin, xMax + 1, yMax + 1)
    }
}