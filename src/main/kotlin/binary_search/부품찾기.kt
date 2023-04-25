package binary_search

/**
 * N개의 부품 중 M개 모두가 있는지 확인
 * 100만개의 부품을 정렬 NlongN -> 20 * 100만
 * 10만개의 부품 확인 => MlongN -> 20 * 10만
 * 시간 복잡도 NlogN
 */

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val data = readLine().split(" ").map { it.toInt() }.sorted()

    val m = readLine().toInt()
    val targets = readLine().split(" ").map { it.toInt() }

    for (i in 0 until m) {
        if (binarySearch(data, targets[i], n)) {
            print("yes ")
        } else {
            print("no ")
        }
    }

    println()
    val data2 = data.toSet()
    for (i in 0 until m) {
        if (set(data2, targets[i])) {
            print("yes ")
        } else {
            print("no ")
        }
    }
}

fun binarySearch(data: List<Int>, target: Int, count: Int): Boolean {
    var start = 0
    var end = count - 1

    while (start <= end) {
        val mid = (start + end) / 2
        if (data[mid] == target) {
            return true
        } else if (data[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return false
}

/**
 * Set
 * 검색: O(1)
 * 삽입: 평균: O(1) -> 해쉬 충돌: O(N)
 */
fun set(data: Set<Int>, target: Int) :Boolean {
    return data.contains(target)
}