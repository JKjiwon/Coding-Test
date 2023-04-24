package bfd_and_dfs

import java.util.*



fun main() = with(System.`in`.bufferedReader()) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(size = n, init = { Array(m) { 0 } })

    for (i in 0 until n) {
        val input = readLine().toCharArray().map { it - '0' }
        for (j in 0 until m) {
            map[i][j] = input[j]
        }
    }

    var result = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) {
                dfs(map, i, j, n, m)
                result++
            }
        }
    }
    println(result)
}

fun dfs(map: Array<Array<Int>>, x: Int, y: Int, n: Int, m: Int) {
    val stack = Stack<Point>()
    stack.add(Point(x, y))

    while (!stack.isEmpty()) {
        val (curX, curY) = stack.pop()
        for (i in 0 until 4) {
            val nextX = curX + dx[i]
            val nextY = curY + dy[i]

            if (nextX in 0 until n && nextY in 0 until m && map[nextX][nextY] == 0) {
                map[nextX][nextY] = 1
                stack.push(Point(nextX, nextY))
            }
        }
    }
}


