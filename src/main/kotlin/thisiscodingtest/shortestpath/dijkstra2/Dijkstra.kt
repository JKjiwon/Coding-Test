package thisiscodingtest.shortestpath.dijkstra2

import java.util.*

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
var n: Int = 0
var m: Int = 0
val pq = PriorityQueue<Node>()
lateinit var graph: Array<MutableList<Node>>
lateinit var distances: IntArray
const val INF = 1e9.toInt()

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        n = it[0]
        m = it[1]
    }
    val start = readLine().toInt()
    graph = Array(n + 1) { mutableListOf() }
    for (i in 0 until m) {
        readLine().split(" ").map { it.toInt() }.also {
            graph[it[0]].add(Node(it[1], it[2]))
        }
    }

    distances = IntArray(n + 1) { INF }

    dijkstra(start)
    for (i in 1..n) {
        if (distances[i] == INF) {
            println("INF")
        } else {
            println(distances[i])
        }
    }
}

fun dijkstra(start: Int) {
    distances[start] = 0
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val (now, dist) = pq.poll()
        if (distances[now] < dist) {
            continue
        }

        for (next in graph[now]) {
            val cost = distances[now] + next.distance
            if (cost < distances[next.index]) { // start -> now -> next, start -> next 비교
                distances[next.index] = cost
                pq.offer(Node(next.index, cost))
            }
        }
    }
}

data class Node(
    val index: Int,
    val distance: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return distance.compareTo(other.distance)
    }
}