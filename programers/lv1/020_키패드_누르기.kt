package programers.lv1

import kotlin.math.abs

class Solution020 {
    fun solution(numbers: IntArray, hand: String): String {
        var result = ""
        val keypad = mapOf<Int, Point>(
            1 to Point(0, 0),
            2 to Point(0, 1),
            3 to Point(0, 2),
            4 to Point(1, 0),
            5 to Point(1, 1),
            6 to Point(1, 2),
            7 to Point(2, 0),
            8 to Point(2, 1),
            9 to Point(2, 2),
            0 to Point(3, 1),
        )

        var left = Point(3, 0)
        var right = Point(3, 2)

        for (number in numbers) {
            val numPoint = keypad[number]!!

            when (number) {
                1, 4, 7 -> {
                    left = numPoint
                    result += "L"
                }

                3, 6, 9 -> {
                    right = numPoint
                    result += "R"
                }

                else -> {
                    val leftDistance = left.distance(numPoint)
                    val rightDistance = right.distance(numPoint)
                    if (leftDistance > rightDistance) {
                        right = numPoint
                        result += "R"
                    } else if (leftDistance < rightDistance) {
                        left = numPoint
                        result += "L"
                    } else {
                        if (hand == "right") {
                            right = numPoint
                            result += "R"
                        } else {
                            left = numPoint
                            result += "L"
                        }
                    }
                }
            }
        }
        return result
    }

    class Point(
        val x: Int,
        val y: Int,
    ) {
        fun distance(other: Point): Int {
            return abs(this.x - other.x) + abs(this.y - other.y)
        }
    }
}