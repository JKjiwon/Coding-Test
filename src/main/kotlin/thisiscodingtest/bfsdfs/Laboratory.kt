package thisiscodingtest.bfsdfs

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            map[i][j] = line[j]
        }
    }
    println(Laboratory(map, n, m).solution())
}

class Laboratory(
    val map: Array<IntArray>,
    val n: Int,
    val m: Int
) {
    val temp = Array(n) { IntArray(m) }
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    var result = 0

    fun solution(): Int {
        dfs(0)
        return result
    }

    private fun dfs(count: Int) {
        if (count == 3) {
            initTemp()
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (temp[i][j] == 2) {
                        virus(i, j)
                    }
                }
            }
            result = max(result, getCount())
            return
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 0) {
                    map[i][j] = 1
                    dfs(count + 1)
                    map[i][j] = 0
                }
            }
        }
    }

    private fun getCount(): Int {
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (temp[i][j] == 0) {
                    count++
                }
            }
        }
        return count
    }

    private fun virus(x: Int, y: Int) {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(Pair(x, y))

        while (stack.isNotEmpty()) {
            val (curX, curY) = stack.pop()
            for (i in 0 until 4) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]

                if (nx in 0 until n && ny in 0 until m && temp[nx][ny] == 0) {
                    stack.push(Pair(nx, ny))
                    temp[nx][ny] = 2
                }
            }
        }
    }

    private fun initTemp() {
        for (i in 0 until n) {
            for (j in 0 until m) {
                temp[i][j] = map[i][j]
            }
        }
    }
}



