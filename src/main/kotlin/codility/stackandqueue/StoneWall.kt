package codility.stackandqueue

import java.util.*

class StoneWall {
    fun solution(H: IntArray): Int {
        val stack = Stack<Int>()
        var count = 0
        for (i in H.indices) {
            // 현재 높이보다 높은 벽 제거
            while (stack.isNotEmpty() && stack.peek() > H[i]) {
                stack.pop()
            }
            // 새로운 벽을 쌓는다.
            if (stack.isEmpty() || stack.isNotEmpty() && stack.peek() < H[i]) {
                stack.push(H[i])
                count++
            }
        }
        return count
    }
}

