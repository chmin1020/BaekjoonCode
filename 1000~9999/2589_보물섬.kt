import java.util.*

lateinit var map: Array<CharArray>
var answer = 0

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    //상수 입력
    val height = st.nextToken().toInt()
    val width = st.nextToken().toInt()

    //맵 입력
    map = Array(height){CharArray(width)}
    for (i in 0 until height)
        map[i] = br.readLine().toCharArray()

    //모든 지점 검사
    for(i in 0 until height)
        for (j in 0 until width)
            if (map[i][j] == 'L')
                bfs(i, j)

    //출력
    println(answer)
    br.close()
}

//방향 상수
const val DIRECT_CNT = 4
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

//위치 데이터 클래스
data class Pos(val x: Int, val y: Int, val dis: Int)

//-- bfs 이용한 거리 구하기 함수 --//
fun bfs(sx: Int, sy: Int) {
    val qu: Queue<Pos> = LinkedList()
    val visited = Array(map.size){BooleanArray(map[0].size){false} }

    //초기값 세팅
    qu.add(Pos(sx, sy, 0))
    visited[sx][sy] = true

    //bfs
    while (qu.isNotEmpty()){
        val cur = qu.poll()

        //거리 갱신
        if(cur.dis > answer)
            answer = cur.dis

        //4방향 체크
        for(d in 0 until DIRECT_CNT){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //범위 체크, 육지 체크, 방문 체크
            if(nx in map.indices && ny in map[0].indices && map[nx][ny] == 'L' && !visited[nx][ny]){
                qu.add(Pos(nx, ny, cur.dis + 1))
                visited[nx][ny] = true
            }
        }
    }
}
