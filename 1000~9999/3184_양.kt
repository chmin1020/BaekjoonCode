import java.util.LinkedList
import java.util.Queue

data class Pos(val x: Int, val y: Int)
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

var sheepCnt = 0
var wolfCnt = 0
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val area = Array(r){ CharArray(c) }
    repeat(r){
        area[it] = br.readLine().toCharArray()
    }

    getAnswer(area, r, c)

    //출력
    with(System.out.bufferedWriter()){
        write("$sheepCnt $wolfCnt\n")
        flush()
        close()
    }
}

//-- bfs 답 구하기 --//
fun getAnswer(area: Array<CharArray>, r: Int, c: Int){
    val visited = Array(r){ BooleanArray(c){ false } }
    for(x in 0 until r){
        for(y in 0 until c){
            if(area[x][y] != '#' && !visited[x][y])
                bfs(area, visited, Pos(x, y))
        }
    }
}

//-- 울타리 내부에서 bfs --//
fun bfs(area: Array<CharArray>, visited: Array<BooleanArray>, start: Pos){
    val qu: Queue<Pos> = LinkedList()
    visited[start.x][start.y] = true
    qu.add(start)

    var sheep = 0
    var wolf = 0
    while (qu.isNotEmpty()){
        val cur = qu.poll()

        //양이나 늑대 수 계산
        when(area[cur.x][cur.y]){
            'o' -> sheep++
            'v' -> wolf++
        }

        //4방향
        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //통과 조건
            if(nx !in area.indices || ny !in area[0].indices) continue
            if(area[nx][ny] == '#' || visited[nx][ny]) continue

            //조치하고 넣기
            visited[nx][ny] = true
            qu.add(Pos(nx, ny))
        }
    }

    if(sheep > wolf) sheepCnt += sheep
    else wolfCnt += wolf
}
