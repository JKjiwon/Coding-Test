package programers.lv1


fun main() {
    val num = 10
    val numString = Integer.toBinaryString(num).padStart(6, '0')
    println(numString)
}