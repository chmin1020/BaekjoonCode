import java.util.*

//위치 데이터 클래스
data class Pos(val x: Int, val y: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //맵입력
    var maxRain = 0
    val map = Array(n){ IntArray(n) }
    for(i in 0 until n){
        val st = StringTokenizer(br.readLine())
        for(j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
            maxRain = maxOf(maxRain, map[i][j])
        }
    }

    //모든 경우의 수 시뮬레이션
    var answer = 1
    for(rain in 1 until maxRain)
        answer = maxOf(answer, simulation(map, rain))

    //출력
    println(answer)
    br.close()
}

//이동 상수
const val moveCnt = 4
val moveX = intArrayOf(-1, 1, 0, 0)
val moveY = intArrayOf(0, 0, -1, 1)

//-- 시뮬레이션 함수 --//
fun simulation(map: Array<IntArray>, rain: Int): Int{
    val visited = Array(map.size){BooleanArray(map.size){false} }

    var cnt = 0
    for(i in map.indices){
        for(j in map.indices){
            //새로운 땅 시작점 발견시 넓이 돌리기
            if(!visited[i][j] && map[i][j] > rain){
                bfs(map, visited, rain, Pos(i, j))
                cnt++
            }
        }
    }
    return cnt
}

//-- bfs 탐색 함수 --//
fun bfs(map: Array<IntArray>, visited: Array<BooleanArray>, rain: Int, start: Pos) {
    val queue: Queue<Pos> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        //가능한 이동 모두 탐색
        for(d in 0 until moveCnt){
            val nx = cur.x + moveX[d]
            val ny = cur.y + moveY[d]

            //맵 범위에 속하고 물에 안 잠김
            if(nx in map.indices && ny in map.indices && map[nx][ny] > rain){
                //이어질 수 있음
                if(!visited[nx][ny]){
                    visited[nx][ny] = true
                    queue.add(Pos(nx, ny))
                }
            }
        }
    }
}
