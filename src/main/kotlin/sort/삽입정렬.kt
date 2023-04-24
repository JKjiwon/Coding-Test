package sort

// 배열을 순회하면서 선택한 값을 오름 차순을 유지하는 곳에 삽입한다.

fun main() {
    val array = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for (i in 1 until array.size) {
        for (j in i downTo 1) {
            if (array[j] < array[j-1]) {
                swap(array, j, j-1)
            } else {
                break
            }
        }
    }

    for (i in array) {
        print("${i} ")
    }
}