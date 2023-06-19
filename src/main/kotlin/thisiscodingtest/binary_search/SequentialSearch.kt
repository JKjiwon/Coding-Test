package thisiscodingtest.binary_search

fun main() = with(System.`in`.bufferedReader()) {
    var inputData = readLine().split(" ")
    val n = inputData[0].toInt()
    val target = inputData[1]

    inputData = readLine().split(" ")
    println(solve(inputData, target, n))
}

private fun solve(words: List<String>, target: String, n: Int): Int {
    for (i in 0 until n) {
        if (words[i] == target) {
            return i + 1
        }
    }
    return -1
}
