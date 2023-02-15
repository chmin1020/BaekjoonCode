import java.util.*

//위치 데이터 클래스
data class Pos(val x: Int, val y: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    //각 테스트 케이스 돌리기
    val answers = mutableListOf<Int>()
    for(test in 0 until tc){
        //입력
        val size = br.readLine().toInt()
        val st1 = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())

        //출발, 도착 설정
        val start = Pos(st1.nextToken().toInt(), st1.nextToken().toInt())
        val target = Pos(st2.nextToken().toInt(), st2.nextToken().toInt())

        answers.add(bfs(size, start, target))
    }

    //내부 계산 및 출력
    println(answers.joinToString("\n"))
    br.close()
}

//이동 상수
const val moveCnt = 8
val moveX = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
val moveY = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

//-- bfs 탐색 함수 --//
fun bfs(size: Int, start: Pos, target: Pos): Int {
    val distances = Array(size){IntArray(size){Int.MAX_VALUE} }

    val queue: Queue<Pos> = LinkedList()
    queue.add(start)
    distances[start.x][start.y] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        if(cur == target)
            return distances[cur.x][cur.y]

        //가능한 이동 모두 탐색
        for(d in 0 until moveCnt){
            val nx = cur.x + moveX[d]
            val ny = cur.y + moveY[d]

            //맵 범위에 속함
            if(nx in 0 until size && ny in 0 until size){
                //더 빠르게 갈 수 있음
                if(distances[nx][ny] > distances[cur.x][cur.y] + 1){
                    distances[nx][ny] = distances[cur.x][cur.y] + 1
                    queue.add(Pos(nx, ny))
                }
            }
        }
    }
    return -1
}
