package sort

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val students = mutableListOf<Student>()

    for (i in 0 until n) {
        val input = readLine().split(" ")
        students.add(Student(input[0], input[1].toInt()))
    }

    students.sort()
    students.map { it.name }.forEach { print("$it ") }
}

data class Student(
    val name: String,
    val score: Int
) : Comparable<Student> {

    override fun compareTo(other: Student): Int {
        return this.score.compareTo(other.score)
    }
}