import java.util.LinkedList
import java.util.Queue

data class Pos(val x: Int, val y: Int)

const val DIRECT_CNT = 4
val directX = intArrayOf(-1,1,0,0)
val directY = intArrayOf(0,0,-1,1)

var answer = Int.MAX_VALUE
var zeroCnt = 0
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //연구소 맵 입력
    val lab = Array(n){ IntArray(n) }
    val virusLocations = ArrayList<Pos>()
    repeat(n){idx ->
        val row = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        row.forEachIndexed { col, value ->
            if(value == 2) virusLocations.add(Pos(idx, col))
            if(value == 0) zeroCnt++
        }
        lab[idx] = row
    }

    //시뮬레이션 돌리기
    selectViruses(lab, virusLocations, 0, m, mutableListOf())

    //출력
    println(if(answer != Int.MAX_VALUE) answer else -1)
}

//-- m개의 바이러스 선택(재귀) --//
fun selectViruses(map: Array<IntArray>, locations: ArrayList<Pos>, cur: Int, targetCnt: Int, selected: MutableList<Pos>){
    //바이러스 선택 완료
    if(selected.size == targetCnt){
        answer = minOf(answer, bfsSearch(getCopyLab(map), selected))
        return
    }

    //더 선택할 바이러스 없음
    if(cur >= locations.size)
        return

    //선택하기, 안하기 경우의 수
    selected.add(locations[cur])
    selectViruses(map, locations, cur + 1, targetCnt, selected)
    selected.removeLast()
    selectViruses(map, locations, cur + 1, targetCnt, selected)
}

//-- 연구소 맵 복사본 --//
fun getCopyLab(lab: Array<IntArray>): Array<IntArray>{
    val copy = Array(lab.size){IntArray(lab[0].size)}
    for(i in lab.indices)
        for(j in lab[0].indices)
            copy[i][j] = lab[i][j]
    return copy
}

//-- 해당 상황에 따른 bfs 탐색 --//
fun bfsSearch(map: Array<IntArray>, initVirus: List<Pos>): Int{
    var time = Int.MAX_VALUE
    var leftCnt = zeroCnt
    if(leftCnt == 0) return 0

    //세팅
    val queue: Queue<Pair<Pos, Int>> = LinkedList()
    queue.addAll(initVirus.map { Pair(it, 0) })
    initVirus.forEach{ map[it.x][it.y] = -1 }

    outer@ while (queue.isNotEmpty()){
        val cur = queue.poll()

        //4방향 탐색
        for(d in 0 until DIRECT_CNT){
            val nx = cur.first.x + directX[d]
            val ny = cur.first.y + directY[d]

            //범위 벗어남
            if(nx !in map.indices || ny !in map[0].indices)
                continue

            //바이러스 전파
            if(map[nx][ny] != 1 && map[nx][ny] != -1){
                if(map[nx][ny] == 0) leftCnt--
                map[nx][ny] = -1
                queue.add(Pair(Pos(nx, ny), cur.second + 1))

                if(leftCnt == 0) {
                    time = cur.second + 1
                    break@outer
                }
            }
        }
    }

    return time
}
