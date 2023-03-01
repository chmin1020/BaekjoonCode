import java.util.*

const val INF = 500000000
const val DIRECT_CNT = 4

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

//경로 찾기 과정을 위한 정보 클래스
data class RouteInfo(val x: Int, val y: Int, val distance: Int) : Comparable<RouteInfo> {
    override fun compareTo(other: RouteInfo): Int {
        return this.distance - other.distance
    }
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //테스트 케이스
    var tcCnt = 1
    while (true) {
        //상수 입력
        val len = br.readLine().toInt()

        //프로그램 종료
        if (len == 0)
            break

        //맵 입력
        val cave = Array(len) { IntArray(len) }
        for (idx in cave.indices)
            cave[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        //답 연산
        val answer = dijkstra(cave, len)

        //출력
        println("Problem ${tcCnt++}: $answer")
    }
    br.close()
}

//-- 다익스트라를 통한 경로 찾기 --//
fun dijkstra(cave: Array<IntArray>, len: Int): Int {
    val visited = Array(len) { BooleanArray(len) { false } }
    val distances = Array(len) { IntArray(len) { INF } }

    val heap = PriorityQueue<RouteInfo>()
    heap.add(RouteInfo(0, 0, cave[0][0]))
    distances[0][0] = cave[0][0]

    while (heap.isNotEmpty()) {
        val cur = heap.poll()

        //중복 체크
        if (visited[cur.x][cur.y]) continue
        visited[cur.x][cur.y] = true

        //4방향 체크
        for(d in 0 until DIRECT_CNT){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //새로운 가능성을 확인했음
            if(nx in 0 until len && ny in 0 until len && distances[nx][ny] > cur.distance + cave[nx][ny]){
                distances[nx][ny] = cur.distance + cave[nx][ny]
                heap.add(RouteInfo(nx, ny, distances[nx][ny]))
            }
        }
    }

    return distances[len - 1][len - 1]
}
