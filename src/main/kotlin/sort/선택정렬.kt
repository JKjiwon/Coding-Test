package sort

/**
 * 1. 배열을 순회하면서 가장 작은 것을 찾는다.
 * 2. 0 ~ N-1 번까지 선택한 위치의 값과 작은 값을 바꾼다.
 */
fun main() {
    val array = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for (i in array.indices) {
        var minIndex = i
        for (j in i until array.size) {
            if (array[minIndex] > array[j]) {
                minIndex = j
            }
        }
        swap(array, minIndex, i)
    }

    for (i in array) {
        print("$i ")
    }
}