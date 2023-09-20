package thisiscodingtest.sort

/**
 * 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸자.
 */

fun main() {
    val array = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
    quickSort(array, 0, array.size - 1)

    for (i in array) {
        print("$i ")
    }

}

fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start >= end) return

    val pivot = start // 호어 분할
    var left = start + 1
    var right = end

    while (left <= right) {
        // left
         while (left <= end && array[left] <= array[pivot]) {
             left++
         }
        // right
        while (right > pivot && array[right] >= array[pivot]) {
            right--
        }
        // swap
        if (left > right) {
            swap(array, pivot, right)
        } else {
            swap(array, left, right)
        }
    }
    quickSort(array, start, right - 1)
    quickSort(array, right + 1, end)
}