package thisiscodingtest.sort

fun swap(array: Array<Int>, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}