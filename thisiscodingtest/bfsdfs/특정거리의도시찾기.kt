package thisiscodingtest.bfsdfs

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }
    val adjList = Array<MutableList<Int>>(n + 1) { mutableListOf() }

    for (i in 0 until m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        adjList[from].add(to)
    }
    val answer = bfs(adjList, k, x)

    if (answer.isEmpty()) {
        println(-1)
    } else {
        answer.sort()
        for (num in answer) {
            println(num)
        }
    }
}

fun bfs(adjList: Array<MutableList<Int>>, k: Int, x: Int): MutableList<Int> {
    val minDist = IntArray(adjList.size) { -1 }
    val answer = mutableListOf<Int>()

    val queue = LinkedList<Int>()
    queue.offer(x)
    minDist[x]++

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (next in adjList[cur]) {
            if (minDist[next] == -1) {
                minDist[next] = minDist[cur] + 1
                queue.offer(next)

                if (minDist[next] == k) {
                    answer.add(next)
                }
            }
        }
    }
    return answer
}