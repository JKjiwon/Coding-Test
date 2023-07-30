package codility.stackandqueue

class Nesting {
    fun solution(S: String): Int {
        var stack = 0

        if (S.isEmpty()) {
            return 1
        }

        if (S.length % 2 == 1) {
            return 0
        }

        for (ch in S) {
            if (ch == '(') {
                stack++
            } else {
                if (stack == 0) {
                    return 0
                }
                stack--
            }
        }
        return if (stack == 0) 1 else 0
    }
}

