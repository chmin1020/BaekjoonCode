import java.util.*

data class MoveInfo(val x:Int, val y:Int, val restK: Int, val step: Int)

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

var answer = Int.MAX_VALUE
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    //배치 입력
    val batch = Array(n){""}
    repeat(n){
        batch[it] = br.readLine()
    }

    //답 구하기
    getAnswer(batch, n, m, k)

    //출력
    with(System.out.bufferedWriter()){
        write("${if(answer == Int.MAX_VALUE) -1 else answer}\n")
        flush()
        close()
    }
}

//-- 정답 구하기 --//
fun getAnswer(batch: Array<String>, n: Int, m: Int, k: Int) {
    val visited = Array(n){ Array(m) { BooleanArray(k + 1) {false} } }
    val queue: Queue<MoveInfo> = LinkedList()
    visited[0][0][0] = true
    queue.add(MoveInfo(0, 0, k, 1))

    //bfs
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        if(cur.x == n - 1 && cur.y == m - 1){
            answer = cur.step
            return
        }

        //4방향
        for(d in 0 until 4){
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            //범위와 못 부수는 벽
            if(nx !in 0 until n || ny !in 0 until m) continue
            if(batch[nx][ny] == '1' && cur.restK <= 0) continue

            if(!visited[nx][ny][k - cur.restK]){
                visited[nx][ny][k - cur.restK] = true
                val newRestK = cur.restK - if(batch[nx][ny] == '1') 1 else 0
                queue.add(MoveInfo(nx, ny, newRestK, cur.step + 1))
            }
        }
    }
}
