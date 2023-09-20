package programers.lv1

class Solution022 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val failRateList = mutableListOf<Pair<Int, Double>>()

        for (i in 1..N) {
            val failRate = getFailRate(i, stages)
            failRateList.add(i to failRate)
        }

        failRateList.sortWith(
            compareByDescending<Pair<Int, Double>> { it.second }
                .then(compareBy { it.second })
        )
        // 입력 순서가 스테이지 순이므로 아래와 같이 표현도 가능
        // failRateList.sortByDescending { it.second }

        return failRateList.map { it.first }.toIntArray()
    }

    private fun getFailRate(stage: Int, stages: IntArray): Double {
        val arrival = stages.count { it >= stage }
        val fail = stages.count { it == stage }
        if (arrival == 0) {
            return 0.0
        }
        return fail / arrival.toDouble()
    }
}