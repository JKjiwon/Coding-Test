package thisiscodingtest.shortestpath.dijkstra

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
lateinit var graph: Array<MutableList<Node>>
lateinit var visited: BooleanArray
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

    visited = BooleanArray(n + 1) { false }
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

// 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드(인덱스)
fun getSmallestNode(): Int {
    var minValue = INF
    var index = 0
    for (i in 1..n) {
        if (!visited[i] && distances[i] < minValue) {
            minValue = distances[i]
            index = i
        }
    }
    return index
}

fun dijkstra(start: Int) {
    distances[start] = 0
    visited[start] = true

    for (node in graph[start]) {
        distances[node.index] = node.distance
    }

    repeat(n - 1) {
        val now = getSmallestNode()
        visited[now] = true
        for (node in graph[now]) {
            val cost = distances[now] + node.distance
            if (cost < distances[node.index]) { // start -> now -> node, start -> node 비교
                distances[node.index] = cost
            }
        }
    }
}

data class Node(
    val index: Int,
    val distance: Int
)