package thisiscodingtest.shortestpath.messenger

/*
3 2 1
1 2 4
1 3 2
 */
import java.util.*
import kotlin.math.max

var N = 0
var M = 0
var C = 0
lateinit var graph: Array<MutableList<City>>
lateinit var distance: IntArray
val pq = PriorityQueue<City>()
const val INF = 1e9.toInt()

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        N = it[0]
        M = it[1]
        C = it[2]
    }

    graph = Array(N + 1) { mutableListOf() }
    repeat(M) {
        readLine().split(" ").map { it.toInt() }.also {
            graph[it[0]].add(City(it[1], it[2]))
        }
    }

    distance = IntArray(N + 1) { INF }

    calMinDistance(C)

    var count = 0
    var totalDistance = 0

    for (dist in distance) {
        if (dist != INF && dist != 0) {
            count++
            totalDistance = max(totalDistance, dist)
        }
    }

    println("$count $totalDistance")
}

fun calMinDistance(start: Int) {
    distance[start] = 0
    pq.offer(City(start, 0))


    while (pq.isNotEmpty()) {
        val (now, dist) = pq.poll()
        if (dist > distance[now]) {
            continue
        }

        for (next in graph[now]) {
            val cost = distance[now] + next.distance
            if (cost < distance[next.index]) {
                distance[next.index] = cost
                pq.offer(City(next.index, cost))
            }
        }
    }
}

data class City(
    val index: Int,
    val distance: Int
) : Comparable<City> {
    override fun compareTo(other: City): Int {
        return distance.compareTo(other.distance)
    }
}