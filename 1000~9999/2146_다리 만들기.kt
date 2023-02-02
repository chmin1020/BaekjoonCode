import java.util.*

data class BridgeInfo(val parent: Pos, val x: Int, val y: Int, val len: Int)
data class Pos(val x: Int, val y: Int)

val DEFAULT_ORIGIN = Pos(-1, -1)

//방향
val directX = intArrayOf(-1, 1, 0 ,0)
val directY = intArrayOf(0, 0, -1, 1)

//맵 크기
var limit = 0

fun main() {
    //입력
    limit = (readLine() ?: "0").toInt()

    val map = Array(limit) { IntArray(limit) }
    for (i in 0 until limit)
        map[i] = (readLine() ?: "0".repeat(limit)).split(" ").map { it.toInt() }.toIntArray()

    //같은 영토끼리 묶기
    val origins = Array(limit) { Array(limit) { Pos(-1, -1) } }

    for (x in 0 until limit)
        for (y in 0 until limit)
            if (map[x][y] == 1 && origins[x][y] == DEFAULT_ORIGIN)
                defineNewLand(origins, map, x, y)

    //다리 제작 시작점 지정
    val queue = LinkedList<BridgeInfo>()
    for (x in 0 until limit)
        for (y in 0 until limit)
            if (map[x][y] == 1)
                queue.add(BridgeInfo(origins[x][y], x, y, 0))

    //출력
    println(findShortestBridge(origins, map, queue))
}

//--좌표가 맵 내에 속하는지 확인하는 함수--//
fun isInMapRange(x: Int, y: Int) = (x in 0 until limit && y in 0 until limit)

//--땅 범위 정의 함수--//
fun defineNewLand(origins: Array<Array<Pos>>, map: Array<IntArray>, startX: Int, startY: Int){
    //땅 시작점 위치 지정
    val startPos = Pos(startX, startY)
    origins[startX][startY] = startPos

    //큐 생성
    val queue: Queue<Pos> = LinkedList()
    queue.add(startPos)

    //bfs
    while(queue.isNotEmpty()){
        val cur = queue.poll()

        //4방향 탐색
        for(directConstant in 0 until 4){
            val nx = cur.x + directX[directConstant]
            val ny = cur.y + directY[directConstant]

            //맵 범위 내, 값이 1, 땅 위치 지정 아직 안됨 -> 현재 땅에 할당
            if(isInMapRange(nx, ny) && map[nx][ny] == 1 && origins[nx][ny] == DEFAULT_ORIGIN) {
                origins[nx][ny] = startPos
                queue.add(Pos(nx, ny))
            }
        }
    }
}

//--다리 제작 방법 탐색 함수--//
fun findShortestBridge(origins: Array<Array<Pos>>, map: Array<IntArray>, queue: Queue<BridgeInfo>): Int{
    val checked = Array(map.size){ Array(map.size){ mutableSetOf<Pos>() } }

    //bfs
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //새로운 땅에 도착했다면 그게 답
        if(map[cur.x][cur.y] == 1 && cur.parent != origins[cur.x][cur.y])
            return cur.len - 1

        //4방향 탐색
        for(directConstant in 0 until 4){
            val nx = cur.x + directX[directConstant]
            val ny = cur.y + directY[directConstant]

            //맵 범위 내, 체크 안함, 같은 땅에 속하지 않음 -> 탐험
            if(isInMapRange(nx, ny) && !checked[nx][ny].contains(cur.parent) && origins[nx][ny] != cur.parent) {
                checked[nx][ny].add(cur.parent)
                queue.add(BridgeInfo(cur.parent, nx, ny, cur.len + 1))
            }
        }
    }
    return -1
}
