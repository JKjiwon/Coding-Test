package thisiscodingtest.bfsdfs

import java.util.*

/*
5 6
101010
111111
000001
111111
111111
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val line = readLine().toCharArray().map { it - '0' }
        for (j in 0 until m) {
            map[i][j] = line[j]
        }
    }

    val answer = solution(map, n, m)
    println(answer)
}

fun solution(map: Array<IntArray>, n: Int, m: Int): Int {
    bfs(map, n, m)
    return map[n - 1][m - 1]

}

private fun bfs(map: Array<IntArray>, n: Int, m: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.poll()

        for (i in 0 until 4) {
            val nx = curX + dx[i]
            val ny = curY + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != 1) {
                continue
            }

            queue.offer(Pair(nx, ny))
            map[nx][ny] = map[curX][curY] + 1

        }
    }
}
