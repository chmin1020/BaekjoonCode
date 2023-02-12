import java.util.*

data class Pos(val x:Int, val y:Int)

//방향 상수
val directX = intArrayOf(-1, 1, 0 ,0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    val height = st.nextToken().toInt()
    val width = st.nextToken().toInt()

    //초기 맵 완성
    val map = Array(height){IntArray(width)}
    for(i in 0 until height){
        st = StringTokenizer(br.readLine())
        for(j in 0 until width)
            map[i][j] = st.nextToken().toInt()
    }

    //치즈 시뮬레이션
    var hour = 0
    var lastCheeseCnt = 0
    while(true){
        //녹이기 시도
        val thisTimeCheeseCnt = cheeseSimulation(map)

        //더 녹을게 없으면 끝
        if(thisTimeCheeseCnt == 0) break

        //갱신
        hour++
        lastCheeseCnt = thisTimeCheeseCnt
    }

    //출력
    println("$hour\n$lastCheeseCnt")
    br.close()
}

//-- 한 시간 텀의 치즈 녹이기 시뮬레이션을 돌리는 함수 --//
fun cheeseSimulation(map: Array<IntArray>): Int{
    var cnt = 0
    val checked = Array(map.size){BooleanArray(map.first().size){false} }

    for(i in map.indices){
        //내부부터는 시작 안함
        for(j in map.first().indices) {
            if (i in 1 until map.lastIndex && j in 1 until map.first().lastIndex)
                continue

            //체크하지 않은 부분이라면 bfs 탐색 시작
            if(!checked[i][j]){
                checked[i][j] = true
                cnt += bfs(map, checked, Pos(i,j))
            }
        }
    }

    return cnt
}

//-- 시뮬레이션을 위한 bfs 함수 --//
fun bfs(map: Array<IntArray>, checked: Array<BooleanArray>, start: Pos): Int{
    val queue:Queue<Pos> = LinkedList()
    queue.add(start)

    val xLimit = map.lastIndex
    val yLimit = map.first().lastIndex

    //bfs
    var cnt = 0
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //4방향 탐색
        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //맵의 범위를 넘지 않음
            if(nx in 0..xLimit && ny in 0..yLimit && !checked[nx][ny]){
                checked[nx][ny] = true
                if(map[nx][ny] == 0) //안 치즈 -> 나아가기
                    queue.add(Pos(nx, ny))
                else {  //치즈 -> 녹이기
                    map[nx][ny] = 0
                    cnt++
                }
            }
        }
    }
    return cnt
}
