package thisiscodingtest.bfsdfs

import java.util.LinkedList

const val INF = Int.MAX_VALUE

class Basic {
}

fun main() {
    /*val adjMatrix = arrayOf(
        arrayOf(0, 7, 5),
        arrayOf(7, 0, INF),
        arrayOf(5, INF, 0)
    )
    for (line in adjMatrix) {
        for (ele in line) {
            print("$ele ")
        }
        println()
    }

    val grape = Array<MutableList<Pair<Int, Int>>>(3) { mutableListOf() }
    grape[0].add(Pair(1, 7))
    grape[0].add(Pair(2, 5))
    grape[1].add(Pair(0, 7))
    grape[2].add(Pair(0, 5))

    for (list in grape) {
        for (node in list) {
            print("(${node.first}, ${node.second}) ")
        }
        println()
    }*/
    // dfs
    val visited = BooleanArray(9)
    val dfsGraph = Array<MutableList<Int>>(9) { mutableListOf() }
    dfsGraph[1].addAll(listOf(2, 3, 8))
    dfsGraph[2].addAll(listOf(1, 7))
    dfsGraph[3].addAll(listOf(1, 4, 5))
    dfsGraph[4].addAll(listOf(3, 5))
    dfsGraph[5].addAll(listOf(3, 4))
    dfsGraph[6].addAll(listOf(7))
    dfsGraph[7].addAll(listOf(2, 6, 8))
    dfsGraph[8].addAll(listOf(1, 7))

    fun dfs(dfsGraph: Array<MutableList<Int>>, visited: BooleanArray, v: Int) {
        visited[v] = true
        println(v)

        for (next in dfsGraph[v]) {
            if (!visited[next]) {
                dfs(dfsGraph, visited, next)
            }
        }
    }

    fun bfs(dfsGraph: Array<MutableList<Int>>, visited: BooleanArray, v: Int) {
        val queue = LinkedList<Int>()
        queue.offer(v)
        visited[v] = true
        println(v)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            for (next in dfsGraph[cur]) {
                if (!visited[next]) {
                    queue.offer(next)
                    visited[next] = true
                    println(next)
                }
            }
        }
    }

    bfs(dfsGraph, visited, 1)
}


