package thisiscodingtest.binary_search


fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val data = readLine().split(" ").map { it.toInt() }

    val result = iterativeBinarySearch(data, n, m)
    println(result)
}

fun iterativeBinarySearch(data: List<Int>, n: Int, target: Int): Int {
    var start = 0
    var end = n - 1

    while (start <= end) {
        val mid = (start + end) / 2

        if (data[mid] == target) {
            return mid
        } else if (data[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}