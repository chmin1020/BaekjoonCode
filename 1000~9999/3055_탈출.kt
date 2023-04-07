import java.util.LinkedList
import java.util.Queue

data class Pos(val x: Int = -1, val y: Int = -1, val step: Int = 0)

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val area = Array(r) { CharArray(c) }
    repeat(r) { idx ->
        area[idx] = br.readLine().toCharArray()
    }

    val answer = getAnswer(area)

    //출력
    with(System.out.bufferedWriter()) {
        write("${if(answer == -1) "KAKTUS" else answer}\n")
        flush()
        close()
    }
}

//-- bfs 답 구하기 --//
fun getAnswer(area: Array<CharArray>): Int {
    var hedgePos = Pos()
    val waterPoses:Queue<Pos> = LinkedList()
    var desPos = Pos()

    //각 기물 위치 파악
    for (x in area.indices) {
        for (y in area[0].indices) {
            when (area[x][y]) {
                'S' -> hedgePos = Pos(x, y)
                'D' -> desPos = Pos(x, y)
                '*' -> waterPoses.add(Pos(x, y))
            }
        }
    }

    return multiBfs(area, hedgePos, waterPoses, desPos)
}

//-- 울타리 내부에서 bfs --//
fun multiBfs(area: Array<CharArray>, start: Pos, waters: Queue<Pos>, end: Pos): Int {
    val qu: Queue<Pos> = LinkedList()
    val visited = Array(area.size){ BooleanArray(area[0].size) {false} }
    visited[start.x][start.y] = true
    qu.add(start)

    var waterCur = -1
    while (qu.isNotEmpty()) {
        val cur = qu.poll()

        //새로운 스텝에서 물이 먼저 움직임
        if(waterCur != cur.step) {
            waterBfs(area, waters)
            waterCur++
        }

        //무사히 도착
        if(cur.x == end.x && cur.y == end.y)
            return cur.step

        // 고슴도치 4방향
        for (d in 0 until 4) {
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //안되는 조건
            if(nx !in area.indices || ny !in area[0].indices ) continue
            if(area[nx][ny] == '*' || area[nx][ny] == 'X') continue
            if(visited[nx][ny]) continue

            //조치하고 넣기
            visited[nx][ny] = true
            qu.add(Pos(nx, ny, cur.step + 1))
        }
    }
    return -1
}

//-- 물의 bfs --//
fun waterBfs(area: Array<CharArray>, waters: Queue<Pos>){
    val cnt = waters.size
    for(i in 0 until cnt){
        if(waters.isEmpty()) break
        val cur = waters.poll()

        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //안되는 조건
            if(nx !in area.indices || ny !in area[0].indices ) continue
            if(area[nx][ny] == '*' || area[nx][ny] == 'D' || area[nx][ny] == 'X') continue

            //새로 넣기
            area[nx][ny] = '*'
            waters.add(Pos(nx, ny))
        }
    }
}
