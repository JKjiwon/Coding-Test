package programers.lv1

class Solution003 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var curPoint: Point = Point(0, 0)
        val maxX = park.size - 1
        val maxY = park[0].length - 1

        for ((i, line) in park.withIndex()) {
            for ((j, point) in line.withIndex()) {
                if (point == 'S') {
                    curPoint = Point(i, j)
                    break
                }
            }
        }

        for (route in routes) {
            val tokens = route.split(" ")
            val dir = Direction.valueOf(tokens[0])
            val count = tokens[1].toInt()

            var move = true
            var newPoint = curPoint

            for (i in 1..count) {
                newPoint = newPoint.move(dir)
                if (newPoint.x > maxX || newPoint.y > maxY ||
                    newPoint.x < 0 || newPoint.y < 0 ||
                    park[newPoint.x][newPoint.y] == 'X'
                ) {
                    move = false
                    break
                }
            }

            if (move) {
                curPoint = newPoint
            }
        }

        return intArrayOf(curPoint.x, curPoint.y)
    }

    class Point(
        val x: Int,
        val y: Int,
    ) {
        fun move(dir: Direction): Point {
            return Point(x + dir.x, y + dir.y)
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        N(-1, 0),
        S(1, 0),
        E(0, 1),
        W(0, -1),
    }
}