package thisiscodingtest.bfsdfs.laboratory

import java.util.*
import kotlin.math.max

lateinit var map: Array<IntArray>
val viruses = mutableListOf<Point>()
var N: Int = 0
var M: Int = 0
const val MAX_WALL = 3
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
var max = 0

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        N = it[0]
        M = it[1]
    }

    map = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 2) {
                viruses.add(Point(i, j))
            }
        }
    }

    dfs(0)
    println(max)
}

fun dfs(wallCount: Int) {
    if (wallCount == MAX_WALL) {
        spreadVirus()
        return
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 0) {
                map[i][j] = 1
                dfs(wallCount + 1)
                map[i][j] = 0
            }
        }
    }
}

fun spreadVirus() {
    val temp = map.map { it.copyOf() }.toTypedArray()
    val queue: Queue<Point> = LinkedList<Point>().apply {
        viruses.forEach { add(it) }
    }

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0..3) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            if (nx in 0 until N && ny in 0 until M && temp[nx][ny] == 0) {
                temp[nx][ny] = 2
                queue.add(Point(nx, ny))
            }
        }
    }
    max = max(
        a = max,
        b = temp.sumOf { it.count { ele -> ele == 0 } }
    )
}

data class Point(
    val x: Int,
    val y: Int,
)