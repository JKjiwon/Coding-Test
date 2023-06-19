package thisiscodingtest.sort

/**
 * 숫자의 개수를 세는 size 가 array 의 max 값 + 1 만큼의 countArray 를 만든다.
 * 시간 복잡도 : O(N+K)
 * 공간 복잡도 : O(N+K)
 */
fun main() {
    val array = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 8)

    val countArray = Array(array.max() + 1) { 0 }

    for (i in array) {
        countArray[i] += 1
    }

    for ((value, count) in countArray.withIndex()) {
        for (i in 0 until count) {
            print("$value ")
        }
    }
}