import java.util.LinkedList
import java.util.Queue

data class MoveInfo(val pos: Pos, val time: Int)
data class Pos(val x: Int = 0, val y: Int = 0, val z: Int = 0)

val directX = intArrayOf(-1, 1, 0, 0, 0, 0)
val directY = intArrayOf(0, 0, -1, 1, 0, 0)
val directZ = intArrayOf(0, 0, 0, 0, -1, 1)

fun main() {
    //세팅
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    while (true){
        //입력
        val (l, r, c) = br.readLine().split(" ").map { it.toInt() }
        if(l == 0 && r == 0 && c == 0) break

        val building = Array(l){ Array(r){ CharArray(c) } }
        val visited = Array(l){ Array(r){ BooleanArray(c) {false} } }

        var start = Pos()
        var end = Pos()
        for(i in 0 until l) {
            for (j in 0 until r)
                building[i][j] = br.readLine().toCharArray()
            br.readLine()
        }

        //시작점과 끝점 찾기
        for(i in 0 until l) {
            for (j in 0 until r) {
                for (k in 0 until c) {
                    when(building[i][j][k]){
                        'S' -> start = Pos(j, k, i)
                        'E' -> end = Pos(j, k, i)
                    }
                }
            }
        }

        val time = bfs(building, visited, start, end)
        bw.write(if(time == -1)"Trapped!\n" else "Escaped in $time minute(s).\n")
    }
    bw.flush()
    bw.close()
}

//--bfs 통한 시간 계산 --//
fun bfs(building: Array<Array<CharArray>>, visited: Array<Array<BooleanArray>>, start: Pos, end: Pos): Int{
    val qu: Queue<MoveInfo> = LinkedList()
    qu.add(MoveInfo(start, 0))
    visited[start.z][start.x][start.y] = true

    while (qu.isNotEmpty()){
        val cur = qu.poll()

        if(cur.pos == end)
            return cur.time

        //4방향 체크
        for(d in 0 until 6){
            val nx = cur.pos.x + directX[d]
            val ny = cur.pos.y + directY[d]
            val nz = cur.pos.z + directZ[d]

            //진행 불가
            if(nz !in building.indices || nx !in building[0].indices || ny !in building[0][0].indices)
                continue
            if(visited[nz][nx][ny] || building[nz][nx][ny] == '#')
                continue

            visited[nz][nx][ny] = true
            qu.add(MoveInfo(Pos(nx, ny, nz), cur.time + 1))
        }
    }
    return -1
}
