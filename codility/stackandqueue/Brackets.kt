package codility.stackandqueue

import java.util.*

//  '(', '{', '[', ']', '}' and/or ')'.
class Brackets {
    fun solution(S: String): Int {
        if (S.isEmpty()) {
            return 1
        }

        val stack = Stack<Char>()

        for (ch in S) {
            if (listOf('(', '{', '[').contains(ch)) {
                stack.push(ch)
                continue
            }

            if (ch == ')' && stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop()
            } else if (ch == '}' && stack.isNotEmpty() && stack.peek() == '{') {
                stack.pop()
            } else if (ch == ']' && stack.isNotEmpty() && stack.peek() == '[') {
                stack.pop()
            } else {
                return 0
            }
        }
        return if (stack.isEmpty()) 1 else 0
    }
    // refactoring
    fun solution2(S: String): Int {
        val stack = Stack<Char>()

        for (ch in S) {
            when (ch) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return 0
                    }
                }
            }
        }
        return if (stack.isEmpty()) 1 else 0
    }
}



