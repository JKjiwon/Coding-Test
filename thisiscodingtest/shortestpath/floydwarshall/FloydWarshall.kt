package thisiscodingtest.shortestpath.floydwarshall

import kotlin.math.min

/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */
var N = 0
var M = 0
lateinit var graph: Array<IntArray>
const val INF = 1e9.toInt()

fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    M = readLine().toInt()

    graph = Array(N + 1) { IntArray(N + 1) { INF } }

    for (i in 1..N) {
        for (j in 1..N) {
            if (i == j) {
                graph[i][j] = 0
            }
        }
    }

    for (i in 1..M) {
        readLine().split(" ").map { it.toInt() }.also {
            graph[it[0]][it[1]] = it[2]
        }
    }

    for (k in 1..N) {
        for (i in 1..N) {
            for (j in 1..N) {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    for (i in 1..N) {
        for (j in 1..N) {
            if (graph[i][j] == INF) {
                print("$INF ")
            } else {
                print("${graph[i][j]} ")
            }
        }
        println()
    }
}
