const val EARLY_ADAPTER = 0
const val NORMAL = 1

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //간선 입력
    val treeInfo = Array(n + 1){ mutableListOf<Int>() }
    val visited = BooleanArray(n + 1){ false }
    val dp = Array(n + 1){ IntArray(2){0} }
    repeat(n - 1){
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        treeInfo[n1].add(n2)
        treeInfo[n2].add(n1)
    }

    //탐색하고 출력
    dfs(treeInfo, dp, visited, 1)
    println(minOf(dp[1][EARLY_ADAPTER], dp[1][NORMAL]))
}

//-- dfs 탐색 --//
fun dfs(treeInfo: Array<MutableList<Int>>, dp: Array<IntArray>, visited: BooleanArray, cur: Int){
    visited[cur] = true

    //자식들 dp 부터 채우기
    treeInfo[cur].forEach {
        if(!visited[it])
            dfs(treeInfo, dp, visited, it)
    }

    //자식들 dp 통해서 본인 dp 계산
    treeInfo[cur].forEach {
        if(!visited[it]){
            dp[cur][EARLY_ADAPTER] += minOf(dp[it][EARLY_ADAPTER], dp[it][NORMAL])
            dp[cur][NORMAL] += dp[it][EARLY_ADAPTER]
        }
    }
    dp[cur][EARLY_ADAPTER] += 1
    visited[cur] = false
}
