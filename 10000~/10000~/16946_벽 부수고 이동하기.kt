import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

const val WALL = -1
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

data class Pos(val x: Int, val y: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //맵 입력
    val map = Array(n) { "0".repeat(m) }
    repeat(n) {
        map[it] = br.readLine()
    }

    //섹터 나누기
    val sectorCountTable = mutableMapOf<Int, Int>()
    val sectorInfoMap = Array(n) { IntArray(m) { WALL } }

    sectorBfs(sectorCountTable, sectorInfoMap, map)

    //정답 배열 만들기
    val answer = Array(n) { IntArray(m) }
    val sectorSet = mutableSetOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (sectorInfoMap[i][j] == WALL) {
                sectorSet.clear()

                //벽 주위 4방향 탐색
                var cnt = 0
                for (d in 0 until 4) {
                    val nx = i + directX[d]
                    val ny = j + directY[d]

                    //범위 초과면 통과
                    if (nx !in 0 until n || ny !in 0 until m)
                        continue

                    //체크 필요 없는 섹터면 통과
                    val curSector = sectorInfoMap[nx][ny]
                    if (curSector == WALL || sectorSet.contains(curSector))
                        continue

                    sectorSet.add(curSector)
                    cnt += sectorCountTable[curSector] ?: 0
                }
                answer[i][j] = (cnt + 1) % 10
            }
        }
    }

    //출력
    val bw = System.out.bufferedWriter()
    for(i in 0 until n){
        for(j in 0 until m)
            bw.write("${answer[i][j]}")
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

//-- 맵 전체를 bfs 하여 각 섹터 영역을 나누는 함수 --//
fun sectorBfs(sectorCountTable: MutableMap<Int, Int>, sectorInfoMap: Array<IntArray>, originMap: Array<String>) {
    val visited = Array(originMap.size) { BooleanArray(originMap[0].length) { false } }
    val queue: Queue<Pos> = LinkedList()

    var sectorNum = 0
    for(i in originMap.indices){
        for(j in originMap[0].indices){
            //새로운 섹터 발견
            if(originMap[i][j] != '1' && !visited[i][j]){
                var sectorWidth = 1
                queue.add(Pos(i, j))
                sectorInfoMap[i][j] = sectorNum
                visited[i][j] = true

                while (queue.isNotEmpty()){
                    val cur = queue.poll()

                    //4방향 탐색
                    for(d in 0 until 4){
                        val nx = cur.x + directX[d]
                        val ny = cur.y + directY[d]

                        if(nx !in originMap.indices || ny !in originMap[0].indices)
                            continue

                        if(originMap[nx][ny] == '1' || visited[nx][ny])
                            continue

                        visited[nx][ny] = true
                        sectorWidth++
                        sectorInfoMap[nx][ny] = sectorNum
                        queue.add(Pos(nx, ny))
                    }
                }
                sectorCountTable[sectorNum++] = sectorWidth
            }
        }
    }
}
