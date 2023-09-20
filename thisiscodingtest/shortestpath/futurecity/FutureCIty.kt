package thisiscodingtest.shortestpath.futurecity

import kotlin.math.min

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
 */

/*
4 2
1 3
2 4
3 4
 */

var N = 0
var M = 0
var X = 0
var K = 0
lateinit var cityGrape: Array<IntArray>
const val INF = 1e9.toInt()

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        N = it[0]
        M = it[1]
    }

    cityGrape = Array(N + 1) { IntArray(N + 1) { INF } }
    for (i in 1..N) {
        for (j in 1..N) {
            if (i == j) {
                cityGrape[i][j] = 0
            }
        }
    }

    repeat(M) {
        readLine().split(" ").map { it.toInt() }.also {
            cityGrape[it[0]][it[1]] = 1
            cityGrape[it[1]][it[0]] = 1
        }
    }
    readLine().split(" ").map { it.toInt() }.also {
        X = it[0]
        K = it[1]
    }

    val answer = solution()
    println(answer)
}

private fun solution(): Int {
    for (k in 1..N) {
        for (a in 1..N) {
            for (b in 1..N) {
                cityGrape[a][b] = min(cityGrape[a][b], cityGrape[a][k] + cityGrape[k][b])
            }
        }
    }

    val result = cityGrape[1][K] + cityGrape[K][X]
    return if (result >= INF) -1 else result
}