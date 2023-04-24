package sort

// 기본 정렬 알고리즘

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val array = Array(n){ 0 }

    for (i in array.indices) {
        array[i] = readLine().toInt()
    }

    array.sortDescending()

    array.forEach { println("$it ") }
}