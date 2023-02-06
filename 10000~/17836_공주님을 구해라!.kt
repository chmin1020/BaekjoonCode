import java.util.*

data class Info(val x: Int, val y: Int, val time: Int)

//이동 방향 상수 배열
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main(){
    //입력
    val (n, m, t) = (readLine()?:"").split(" ").map { it.toInt() }
    val map = Array(n){IntArray(m){0} }
    for(i in 0 until n)
        map[i] = (readLine()?:"").split(" ").map { it.toInt() }.toIntArray()

    //답 변수
    var answer = Int.MAX_VALUE

    //visited
    val visited = Array(n){BooleanArray(m){false} }.also { it[0][0] = true }

    //bfs
    val queue: Queue<Info> = LinkedList()
    queue.add(Info(x = 0, y = 0, time = 0))

    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //시간 초과
        if(cur.time > t)
            break

        //도착
        if(cur.x == n - 1 && cur.y == m - 1){
            //칼을 들었을 때 최단과 아닐 때 최단 비교
            answer = minOf(answer, cur.time)
            break
        }

        //4방향 체크
        for(directConstant in 0 until 4){
            val nx = cur.x + directX[directConstant]
            val ny = cur.y + directY[directConstant]

            //갈 수 있는 공간 도달
            if(isInRange(nx, ny, n, m) && !visited[nx][ny] && map[nx][ny] != 1){
                queue.add(Info(nx, ny, cur.time + 1))
                visited[nx][ny] = true

                //칼을 집었을 때 최단거리 저장
                if(map[nx][ny] == 2) {
                    val swordShortest = (cur.time + 1) + (n + m) - (nx + ny) - 2

                    if(swordShortest <= t)
                    answer = swordShortest
                }
            }
        }
    }

    //출력
    if(answer == Int.MAX_VALUE) println("Fail")
    else println(answer)
}

//-- 지도 범위 체크 함수 --//
fun isInRange(x: Int, y: Int, xLimit: Int, yLimit: Int) = (x in 0 until xLimit && y in 0 until yLimit)
