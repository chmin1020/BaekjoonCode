fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //관계 입력
    val graph = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        val (p1, p2) = br.readLine().split(" ").map { it.toInt() }
        graph[p1].add(p2)
        graph[p2].add(p1)
    }

    //dfs
    var answer = 0
    for (person in graph.indices) {
        val alreadyCheck = BooleanArray(n).also { it[person] = true }
        if (dfs(graph, alreadyCheck, person, 1)) {
            answer = 1
            break
        }
    }

    //출력
    println(answer)
    br.close()
}

//-- dfs 통한 조합 및 순열 --//
fun dfs(graph: Array<MutableList<Int>>, alreadyCheck: BooleanArray, cur: Int, len: Int): Boolean {
    //5명 연속 -> 성공
    if (len == 5)
        return true

    //모든 친구 탐색
    for (friend in graph[cur]) {
        if (!alreadyCheck[friend]) {
            alreadyCheck[friend] = true

            //ABCDE 찾았으면 끝
            if (dfs(graph, alreadyCheck, friend, len + 1))
                return true

            alreadyCheck[friend] = false
        }
    }

    return false
}
