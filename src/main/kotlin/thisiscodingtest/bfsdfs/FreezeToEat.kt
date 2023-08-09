package thisiscodingtest.bfsdfs

import java.util.*

/*
4 5
00110
00011
11111
00000
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until n) {
        val line = readLine().toCharArray().map { it - '0' }
        for (j in 0 until m) {
            map[i][j] = line[j]
        }
    }

    val result = FreezeToEat(map, n, m).solution()
    println(result)
}

class FreezeToEat(
    val map: Array<IntArray>,
    val n: Int,
    val m: Int
) {

    fun solution(): Int {
        var answer = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (dfsR(i, j)) {
                    answer++
                }
            }
        }
        return answer
    }

    private fun dfs(x: Int, y: Int) {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(Pair(x, y))
        map[x][y] = 1

        while (stack.isNotEmpty()) {
            val (curX, curY) = stack.pop()
            for (i in 0 until 4) {
                val nextX = curX + dx[i]
                val nextY = curY + dy[i]

                if (nextX in 0 until n && nextY in 0 until m && map[nextX][nextY] == 0) {
                    stack.push(Pair(nextX, nextY))
                    map[nextX][nextY] = 1
                }
            }
        }
    }

    private fun dfsR(x: Int, y: Int): Boolean {
        // 종료 조건
        if (x !in 0 until n || y !in 0 until m) {
            return false
        }

        if (map[x][y] == 0) {
            map[x][y] = 1
            dfsR(x - 1, y)
            dfsR(x + 1, y)
            dfsR(x, y - 1)
            dfsR(x, y + 1)
            return true
        }

        return false
    }
}