import java.util.*

data class PossibleCase(var selected: Int = 0, var notSelected: Int = 0)

lateinit var populations: IntArray
lateinit var tree: Array<MutableList<Int>>
lateinit var dp: Array<PossibleCase>
lateinit var visited: BooleanArray

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //풀이를 위한 배열 설정(인구수 저장, 트리 정보 저장, dp 정보 저장, 방문 여부 저장)
    populations = IntArray(n)
    tree = Array(n){ mutableListOf()}
    dp = Array(n){PossibleCase()}
    visited = BooleanArray(n){false}

    //인구수 완성
    var st = StringTokenizer(br.readLine())
    for(i in 0 until n)
        populations[i] = st.nextToken().toInt()

    //트리 완성
    for(i in 0 until n - 1){
        st = StringTokenizer(br.readLine())
        val n1 = st.nextToken().toInt() - 1
        val n2 = st.nextToken().toInt() - 1

        tree[n1].add(n2)
        tree[n2].add(n1)
    }

    //dp 채우기
    fillDp(0)

    //출력
    println(maxOf(dp[0].notSelected, dp[0].selected))
    br.close()
}

//-- dfs 통한 트리 dp 채우기 함수 --//
fun fillDp(node: Int){
    visited[node] = true

    //아래 노드들 다 탐방
    tree[node].forEach {
        if(!visited[it])
            fillDp(it)
    }

    //본인 dp 채우기
    tree[node].forEach {
        if(!visited[it]){
            dp[node].selected += dp[it].notSelected //현재 노드 선택 시에는 하위 노드 모두 선택 x)
            dp[node].notSelected += maxOf(dp[it].selected, dp[it].notSelected) //현재 노드 미 선택 시에는 최대를 위한 노드 선택
        }
    }
    dp[node].selected += populations[node]
    visited[node] = false
}
