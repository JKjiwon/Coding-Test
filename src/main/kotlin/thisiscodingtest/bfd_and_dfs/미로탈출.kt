package thisiscodingtest.bfd_and_dfs

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { Array(m) { 0 } }


    for (i in map.indices) {
        val input = readLine().toCharArray().map { it - '0' }
        for (j in map[0].indices) {
            map[i][j] = input[j]
        }
    }

    bfs(map, n, m)

    println("${map[n-1][m-1]}")
}

fun bfs(map: Array<Array<Int>>, n: Int, m: Int) {
    val queue = LinkedList<Point>()
    queue.offer(Point(0, 0))

    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.poll()

        for (i in 0 until 4) {
            val nx = curX + dx[i]
            val ny = curY + dy[i]

            if (nx in 0 until n && ny in 0 until m && map[nx][ny] == 1) {
                queue.offer(Point(nx, ny))
                map[nx][ny] = map[curX][curY] + 1
            }
        }
    }
}