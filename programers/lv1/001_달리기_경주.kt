package programers.lv1

class Solution001 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // idx 검색 시간을 줄여보자
        val playerMap = mutableMapOf<String, Int>()

        players.forEachIndexed { i, p ->
            playerMap[p] = i
        }

        for (name in callings) {
            val idx: Int = playerMap[name]!!
            swap(players, playerMap, idx - 1, idx)
        }
        return players
    }

    private fun swap(players: Array<String>, playerMap: MutableMap<String, Int>, i: Int, j: Int) {
        val temp = players[i]
        players[i] = players[j]
        players[j] = temp

        val iName = players[i]
        val jName = players[j]
        playerMap[iName] = i
        playerMap[jName] = j
    }

    private fun findIndex(players: Array<String>, targetName: String): Int {
        for ((idx, name) in players.withIndex()) {
            if (name == targetName) {
                return idx
            }
        }
        return -1;
    }
}