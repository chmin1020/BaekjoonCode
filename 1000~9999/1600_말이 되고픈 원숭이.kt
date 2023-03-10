import java.util.LinkedList
import java.util.Queue

const val DIRECT_CNT = 4
const val HORSE_CNT = 8
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)
val horseMoveX = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
val horseMoveY = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

data class MoveInfo(val x: Int, val y: Int, val horseLeft: Int, val cnt: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val k = br.readLine().toInt()
    val (w, h) = br.readLine().split(" ").map { it.toInt() }

    //맵 입력
    val map = Array(h) { IntArray(w) }
    repeat(h) {
        map[it] = br.readLine().split(" ").map { each -> each.toInt() }.toIntArray()
    }

    //bfs 돌리기
    val answer = bfs(map, k)

    //출력
    println(answer)
}

//-- bfs 탐색 --//
fun bfs(map: Array<IntArray>, k: Int): Int {
    val qu: Queue<MoveInfo> = LinkedList()
    val visited = Array(map.size) { Array(map[0].size){BooleanArray(k + 1) { false }} }

    visited[0][0][k] = true
    qu.add(MoveInfo(0, 0, k, 0))

    var result = -1
    while (qu.isNotEmpty()){
        val cur = qu.poll()

        //가장 빨리 도달
        if(cur.x == map.lastIndex && cur.y == map[0].lastIndex){
            result = cur.cnt
            break
        }

        //일반적인 움직임
        for(d in 0 until DIRECT_CNT){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //갈 수 있으면 방문
            if(isPossibleDestination(map, visited, nx, ny, cur.horseLeft)){
                visited[nx][ny][cur.horseLeft] = true
                qu.add(MoveInfo(nx, ny, cur.horseLeft, cur.cnt + 1))
            }
        }

        if(cur.horseLeft > 0){
            for(d in 0 until HORSE_CNT){
                val nx = cur.x + horseMoveX[d]
                val ny = cur.y + horseMoveY[d]
                val newHorseLeft = cur.horseLeft - 1

                //갈 수 있으면 방문
                if(isPossibleDestination(map, visited, nx, ny, newHorseLeft)){
                    visited[nx][ny][newHorseLeft] = true
                    qu.add(MoveInfo(nx, ny, newHorseLeft, cur.cnt + 1))
                }
            }
        }
    }

    return result
}

//-- 갈 수 있는 곳인지 체크 --//
fun isPossibleDestination(map: Array<IntArray>, visited: Array<Array<BooleanArray>>, x: Int, y: Int, k: Int): Boolean{
    //범위 벗어남
    if(x !in map.indices || y !in map[0].indices)
        return false

    //도착지가 장애물 또는 이미 방문
    if(map[x][y] == 1 || visited[x][y][k])
        return false

    return true
}
