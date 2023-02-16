import java.util.*

//위치 데이터 클래스
data class Pos(val x: Int, val y: Int)

val areas = mutableListOf<Int>()
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    //상수 입력
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    //맵 설정
    val map = Array(n){ BooleanArray(m) }
    for(i in 0 until k){
        //꼭짓점 입력
        st = StringTokenizer(br.readLine())
        val sx = st.nextToken().toInt()
        val sy = st.nextToken().toInt()
        val ex = st.nextToken().toInt()
        val ey = st.nextToken().toInt()

        //영역 색칠
        for(x in sx until ex)
            for(y in sy until ey)
                map[x][y] = true
    }

    //모든 경우의 수 시뮬레이션
    val answer = simulation(map)
    areas.sort()

    //출력
    println(answer)
    println(areas.joinToString(" "))
    br.close()
}

//이동 상수
const val moveCnt = 4
val moveX = intArrayOf(-1, 1, 0, 0)
val moveY = intArrayOf(0, 0, -1, 1)

//-- 시뮬레이션 함수 --//
fun simulation(map: Array<BooleanArray>): Int{
    val visited = Array(map.size){BooleanArray(map[0].size){false} }

    var cnt = 0
    for(i in map.indices){
        for(j in map[0].indices){
            //새로운 땅 시작점 발견시 넓이 돌리기
            if(!visited[i][j] && !map[i][j]){
                bfs(map, visited, Pos(i, j))
                cnt++
            }
        }
    }
    return cnt
}

//-- bfs 탐색 함수 --//
fun bfs(map: Array<BooleanArray>, visited: Array<BooleanArray>, start: Pos) {
    val queue: Queue<Pos> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    var cnt = 0
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        cnt++

        //가능한 이동 모두 탐색
        for(d in 0 until moveCnt){
            val nx = cur.x + moveX[d]
            val ny = cur.y + moveY[d]

            //맵 범위에 속하고 직사각형에 속하지 않음
            if(nx in map.indices && ny in map[0].indices && !map[nx][ny]){
                //이어질 수 있음
                if(!visited[nx][ny]){
                    visited[nx][ny] = true
                    queue.add(Pos(nx, ny))
                }
            }
        }
    }
    areas.add(cnt)
}
