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

    var answer = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (dfs2(map, i, j, n, m)) {
                answer++
            }
        }
    }
    println(answer)
}

fun dfs(map: Array<IntArray>, x: Int, y: Int, n: Int, m: Int) {
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

fun dfs2(map: Array<IntArray>, x: Int, y: Int, n: Int, m: Int): Boolean {
    // 종료 조건
    if (x !in 0 until n || y !in 0 until m) {
        return false
    }

    if (map[x][y] == 0) {
        map[x][y] = 1
        dfs2(map, x - 1, y, n, m)
        dfs2(map, x + 1, y, n, m)
        dfs2(map, x, y - 1, n, m)
        dfs2(map, x, y + 1, n, m)
        return true
    }
    // map[x][y] == 1
    return false
}