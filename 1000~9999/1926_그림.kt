import java.util.LinkedList
import java.util.Queue

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

data class Pos(val x: Int, val y: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //맵 입력
    val map = Array(n) { IntArray(m) }
    repeat(n) {row ->
        map[row] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    //답 구하기
    var areaCnt = 0
    var maxArea = 0
    val visited = Array(n){ BooleanArray(m){ false } }
    for(i in 0 until n){
        for(j in 0 until m){
            if(map[i][j] == 1 && !visited[i][j]){
                areaCnt++
                maxArea = maxOf(maxArea, sectorBfs(map, visited, Pos(i, j)))
            }
        }
    }

    //출력
    with(System.out.bufferedWriter()){
        write("$areaCnt\n")
        write("$maxArea\n")
        flush()
        close()
    }
}

//-- 맵 전체를 bfs 하여 각 섹터 영역을 나누는 함수 --//
fun sectorBfs(map: Array<IntArray>, visited: Array<BooleanArray>, start: Pos): Int {
    val queue: Queue<Pos> = LinkedList()
    visited[start.x][start.y] = true
    queue.add(start)

    var sectorArea = 1
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //4방향 탐색
        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            if(nx !in map.indices || ny !in map[0].indices)
                continue

            //새 넓이 확인
            if(map[nx][ny] == 1 && !visited[nx][ny]){
                visited[nx][ny] = true
                queue.add(Pos(nx, ny))
                sectorArea++
            }
        }
    }

    return sectorArea
}
