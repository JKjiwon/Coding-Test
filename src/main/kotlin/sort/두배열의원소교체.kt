package sort

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arrayA = Array(n) { 0 }
    val arrayB = Array(n) { 0 }

    val inputA = readLine().split(" ").map { it.toInt() }
    val inputB = readLine().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        arrayA[i] = inputA[i]
    }

    for (i in 0 until n) {
        arrayB[i] = inputB[i]
    }

    arrayA.sort()
    arrayB.sortDescending()

    var aIdx = 0
    var bIdx = 0

    for (i in 0 until k) {
        if (arrayA[aIdx] < arrayB[bIdx]) {
            arrayA[aIdx] = arrayB[bIdx]
            aIdx++
            bIdx++
        }
    }
    println(arrayA.sum())
}