import java.util.*

const val INF = 10000000
val dp = Array(61){Array(61){IntArray(61){INF} } }

//뮤탈의 공격 경우의 수
val combos = mutableListOf(
    intArrayOf(9, 3, 1),
    intArrayOf(9, 1, 3),
    intArrayOf(3, 9, 1),
    intArrayOf(3, 1, 9),
    intArrayOf(1, 9, 3),
    intArrayOf(1, 3, 9)
)

//현재 scv 상태 데이터
data class Status(val hp1: Int, val hp2: Int, val hp3: Int, val cnt: Int)

fun main() {
    //입력
    readLine()
    val scv = (readLine() ?: "").split(" ").map { it.toInt() }
    val hps = IntArray(3)

    //3개의 hp 받기, 더 적으면 0 채우기
    for(i in scv.indices)
        hps[i] = scv[i]
    for(i in scv.size until 3)
        hps[i] = 0

    //최소 찾기
    findShortest(Status(hps[0], hps[1], hps[2], 0))

    //출력
    println(dp[0][0][0])
}

//--bfs 통해 최소 공격 횟수 찾는 함수--//
fun findShortest(initStatus: Status){
    val queue: Queue<Status> = LinkedList()
    queue.add(initStatus)

    //bfs
    while(queue.isNotEmpty()){
        val cur = queue.poll()

        //상태에 따른 경우의 수 추가
        doCombo(queue, cur)

        //다 죽었으면 리턴
        if(dp[0][0][0] != INF)
            break
    }
}

//--현재 케이스 상태에 따른 연산 및 저장을 수행하는 함수--//
fun doCombo(queue: Queue<Status>, cur: Status){
    //모든 경우의 수 탐색하여 큐에 저장
    combos.forEach {
        //공격에 따른 hp 갱신
        val newHp1 = if(cur.hp1 - it[0] >= 0) cur.hp1 - it[0] else 0
        val newHp2 = if(cur.hp2 - it[1] >= 0) cur.hp2 - it[1] else 0
        val newHp3 = if(cur.hp3 - it[2] >= 0) cur.hp3 - it[2] else 0

        //아직 나오지 않은 체력 셋이면 dp 및 큐 추가
        if(dp[newHp1][newHp2][newHp3] == INF) {
            queue.add(Status(newHp1, newHp2, newHp3, cur.cnt + 1))
            dp[newHp1][newHp2][newHp3] = cur.cnt + 1
        }
    }
}
