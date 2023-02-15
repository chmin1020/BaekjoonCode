import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    //입력(상수)
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    //입력(맵)
    val map = Array(n) { CharArray(m) }
    for (i in 0 until n)
        map[i] = br.readLine().toCharArray()

    //내부 계산 및 출력
    println(simulation(map))
    br.close()
}

//상수
const val NOT_DECIDED = -1
const val DECIDING = -2

//방향 맵
val directX = mutableMapOf('U' to -1, 'D' to 1)
val directY = mutableMapOf('L' to -1, 'R' to 1)

//위치 데이터 클래스
data class Pos(val x: Int, val y: Int)

//-- 구역 개수 체크 시뮬레이션 함수 --//
fun simulation(map: Array<CharArray>): Int {
    val teamNumbers = Array(map.size) { IntArray(map.first().size) { NOT_DECIDED } }

    var cnt = 0
    for (i in map.indices)
        for (j in map[i].indices)
            //새로운 이동 범주 발견 (+1)
            if (teamNumbers[i][j] == NOT_DECIDED && bfs(map, teamNumbers, Pos(i, j), cnt))
                    cnt++

    //이동 구역 개수 반환
    return cnt
}

//-- bfs 탐색 함수 --//
fun bfs(map: Array<CharArray>, teamNumbers: Array<IntArray>, start: Pos, newNumber: Int): Boolean {
    val queue: Queue<Pos> = LinkedList()
    queue.add(start)

    val teamMembers = mutableListOf(start)
    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        //정보에 따른 다음 위치
        val nx = cur.x + (directX[map[cur.x][cur.y]] ?: 0)
        val ny = cur.y + (directY[map[cur.x][cur.y]] ?: 0)

        when(teamNumbers[nx][ny]) {
            NOT_DECIDED -> {
                //방문하지 않은 곳이면 방문
                queue.add(Pos(nx, ny))
                teamMembers.add(Pos(nx, ny))
                teamNumbers[nx][ny] = DECIDING
            }
            DECIDING -> {
                //현재 팀의 사이클이 완성되면 팀 추가
                teamMembers.forEach { teamNumbers[it.x][it.y] = newNumber}
                return true
            }
            else -> {
                //이미 정해진 팀이면 그 팀으로
                teamMembers.forEach { teamNumbers[it.x][it.y] = teamNumbers[nx][ny] }
                return false
            }
        }
    }
    return true
}
