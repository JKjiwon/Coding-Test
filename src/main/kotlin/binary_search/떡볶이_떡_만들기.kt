package binary_search

/**
 * 떡의 최대기 길이가 20억 이므로 31번 만에 최적해를 찾을 수 있다.
 * 자르고 난뒤 떡의 길이를 더해야 하므로 최대 100만번의 연산
 * 최대 3000만번의 연산이 필요하다.
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val data = readLine().split(" ").map { it.toInt() }

    println(solve(data, m, n))
}

fun solve(data: List<Int>, m: Int, n: Int): Int {
    var start = 0
    var end = data[n - 1]

    var max = 0
    while (start <= end) {
        val mid = (start + end) / 2
        if (slice(data, mid) >= m) { // 최대한 적은 길이의 떡이 남았을때 갱신!!
            max = mid
            start = mid + 1
        } else if (slice(data, mid) < m) {
            end = mid - 1
        }
    }
    return max
}

// data 를 h로 잘랐을때의 떡을 길이
fun slice(data: List<Int>, h: Int): Int {
    var result = 0
    for (num in data) {
        if (num > h) {
            result += (num - h)
        }
    }
    return result
}
