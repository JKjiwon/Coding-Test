package programers.lv1

import java.util.*

// Stack을 이욜하면 쉽게 표현 가능
class Solution021 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var basket = Stack<Int>()
        var result = 0
        for (i in moves) {
            var pick = 0
            for (j in 0..board.size - 1) {
                if (board[j][i - 1] != 0) {
                    pick = board[j][i - 1]
                    board[j][i - 1] = 0
                    break
                }
            }

            if (pick != 0) {
                if (basket.size == 0) {
                    basket.push(pick)
                } else {
                    if (basket.peek() == pick) {
                        basket.pop()
                        result += 2
                    } else {
                        basket.push(pick)
                    }
                }
            }
        }

        return result
    }
}