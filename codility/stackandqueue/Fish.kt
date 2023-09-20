package codility.stackandqueue

import java.util.*

// 방향이 다르다고 싸우지 않는다.
// 위에 있는 물고기가 방향이 1 이고 아래 있는 물고기가 방향이 0 일때 싸운다.
// 올라가는 물고기는 내려가는 물고기와 여러번 싸울수 있다.
class Fish {
    fun solution(A: IntArray, B: IntArray): Int {
        val alive = Stack<Int>()
        alive.push(0)

        for (i in 1 until A.size) {
            while (true) {
                val top = alive.peek()
                if (B[top] == 1 && B[i] == 0) { // 서로 만날 때
                    // 크기가 작으면 잡아 먹힌다.
                    if (A[top] < A[i]) {
                        alive.pop()
                    } else {
                        break
                    }
                } else {
                    // 서로 만나지 않을 때
                    alive.push(i)
                    break
                }
                if (alive.isEmpty()) { // 올라가는 물고기가 내려가는 물고기를 다먹어치웠을 때
                    alive.push(i)
                    break
                }
            }
        }
        return alive.size
    }

    fun solution2(A: IntArray, B: IntArray): Int {
        val downstream = Stack<Int>()
        var upstreamCount = 0

        for (i in A.indices) {
            if (B[i] == 1) { // 내려가는 물고기
                downstream.push(A[i])
            } else { // 올라가는 물고기
                while (downstream.isNotEmpty()) {
                    val lastSize = downstream.peek()
                    if (lastSize > A[i]) { // 내려가는 물고기 사이즈가 더 클 때
                        break
                    } else { // 올라가는 물고기 사이즈가 더 클 때
                        downstream.pop()
                    }
                }
                if (downstream.isEmpty()) {
                    upstreamCount++
                }
            }
        }
        return upstreamCount + downstream.size
    }
}



