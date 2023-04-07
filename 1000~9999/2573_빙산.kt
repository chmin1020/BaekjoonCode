import java.util.LinkedList
import java.util.Queue

data class Pos(val x: Int, val y: Int)

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val area = Array(n) { IntArray(m) }
    repeat(n) { idx ->
        area[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val answer = getAnswer(area)

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}

//-- bfs 답 구하기 --//
fun getAnswer(area: Array<IntArray>): Int {
    var bergCnt = 1
    var year = 0

    while (bergCnt > 0) {
        bergCnt = 0
        val visited = Array(area.size) { BooleanArray(area[0].size) { false } }
        val meltMap = Array(area.size) { IntArray(area[0].size) { 0 } }

        //빙산 개수 파악
        for (i in area.indices) {
            for (j in area[0].indices) {
                if (area[i][j] > 0 && !visited[i][j]) {
                    bergCnt++
                    bfs(area, meltMap, visited, Pos(i, j))
                }
            }
        }

        //빙산이 분리됨
        if (bergCnt > 1) return year

        //빙산 녹기
        for (i in area.indices)
            for (j in area[0].indices)
                if (meltMap[i][j] > 0)
                    area[i][j] = area[i][j] - meltMap[i][j]
        year++
    }
    return 0
}

//-- 울타리 내부에서 bfs --//
fun bfs(area: Array<IntArray>, meltMap: Array<IntArray>, visited: Array<BooleanArray>, start: Pos) {
    val qu: Queue<Pos> = LinkedList()
    visited[start.x][start.y] = true
    qu.add(start)

    while (qu.isNotEmpty()) {
        val cur = qu.poll()

        //4방향
        for (d in 0 until 4) {
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //통과 조건
            if (nx !in area.indices || ny !in area[0].indices) continue
            if(visited[nx][ny]) continue
            if (area[nx][ny] <= 0){
                meltMap[cur.x][cur.y]++
                continue
            }

            //조치하고 넣기
            visited[nx][ny] = true
            qu.add(Pos(nx, ny))
        }
    }
}
