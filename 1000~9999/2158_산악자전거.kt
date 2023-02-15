import java.util.*
import kotlin.math.pow

//이동 정보 데이터 클래스
data class Info(val x: Int, val y: Int, val cost: Double, val velocity: Double) : Comparable<Info> {
    override fun compareTo(other: Info): Int{
        return when {
            this.cost > other.cost -> 1
            this.cost == other.cost -> 0
            else -> -1
        }
    }
}

//위치 이동 배열
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    //v,r,c 입력
    val v = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    //맵 입력
    val map = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until c)
            map[i][j] = st.nextToken().toInt()
    }

    //내부 계산 및 출력
    println(String.format("%.2f", dijkstra(map, v.toLong(), r, c)))
    br.close()
}

//-- 속도와 시간 다익스트라 --//
const val INF = 1000000000000.0
fun dijkstra(map: Array<IntArray>, v: Long, r: Int, c: Int): Double {
    val heap = PriorityQueue<Info>()
    val checked = Array(r){Array(c){Pair(INF, -1.0)} } //시간, 속도 순

    heap.add(Info(0, 0, 0.0, v.toDouble()))
    checked[0][0] = Pair(0.0, v.toDouble())
    while(heap.isNotEmpty()){
        val cur = heap.poll()

        if(cur.x == r - 1 && cur.y == c - 1)
            return cur.cost

        //중복 체크
        if(checked[cur.x][cur.y].first < cur.cost)
            continue
        if(checked[cur.x][cur.y].first == cur.cost && checked[cur.x][cur.y].second > cur.velocity)
            continue

        //네 방향 탐색
        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //맵 범위에 포함됨
            if(nx in 0 until r && ny in 0 until c){
                //다음 턴으로 갈 때의 시간과 속도
                val nextCost = cur.cost + (1 / cur.velocity)
                val nextVelocity = cur.velocity * (2.0).pow((map[cur.x][cur.y] - map[nx][ny]).toDouble())

                //중복 체크
                if(checked[nx][ny].first < nextCost)
                    continue
                if(checked[nx][ny].first == nextCost && checked[nx][ny].second >= nextVelocity)
                    continue

                //아직 확정되지 않았고 더 빠르게 방문할 수 있음 -> 힙에 추가
                checked[nx][ny] = Pair(nextCost, nextVelocity)
                heap.add(Info(nx, ny, nextCost, nextVelocity))
            }
        }
    }

    return checked[r - 1][c - 1].first
}
