package thisiscodingtest.binary_search

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val data = readLine().split(" ").map { it.toInt() }

    val result = recursiveBinarySearch(data, m, 0, n - 1)
    println(result)
}

/**
 * 단계 마다 탐색 범위가 반으로 줄어든다.
 * 시간 복잡도 O(logN)
 * 데이터가 정렬이 되어 있어야 한다.
 */
private fun recursiveBinarySearch(data: List<Int>, target: Int, start: Int, end: Int): Int {
    if (start > end) {
        return -1
    }
    val mid = (start + end) / 2

    if (data[mid] == target) {
        return mid
    } else if (data[mid] > target) {
        return recursiveBinarySearch(data, target, start, mid - 1)
    } else {
        return recursiveBinarySearch(data, target, mid + 1, end)
    }
}
