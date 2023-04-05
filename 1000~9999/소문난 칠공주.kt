import java.util.LinkedList
import java.util.Queue

var cnt = 0
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val batch = Array(5){""}

    //배치 입력
    repeat(5){
        batch[it] = br.readLine()
    }

    //답 구하기
    getAnswer(batch)

    //출력
    with(System.out.bufferedWriter()){
        write("$cnt\n")
        flush()
        close()
    }
}

data class Pos(val x:Int = -1, val y:Int = -1)

val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

//-- 정답 구하기 --//
fun getAnswer(batch: Array<String>) {
    val girls = Array(7){ Pos() }

    for(i in 0 until 5){
        for(j in 0 until 5){
            girls[0] = Pos(i, j)
            if(batch[i][j] == 'Y') pickGirl(batch, girls, 1, 1, Pos(i, j))
            else pickGirl(batch, girls, 1, 0, Pos(i, j))
        }
    }
}

//-- 자리 뽑기 --//
fun pickGirl(batch: Array<String>, girls: Array<Pos>, total: Int, yCnt: Int, perPos: Pos){
    //도연파 다수
    if(yCnt >= 4)
        return

    //연속 확인
    if(total == 7){
        if(checkContinuous(girls)) cnt++
        return
    }

    //나머지 조합 찾기
    for(i in perPos.x until 5){
        for(j in 0 until 5){
            //앞에 것은 더 선택할 필요 없음
            if(perPos.x == i && perPos.y >= j)
                continue

            girls[total] = Pos(i, j)
            if (batch[i][j] == 'Y') pickGirl(batch, girls, total + 1, yCnt + 1, Pos(i, j))
            else pickGirl(batch, girls, total + 1, yCnt, Pos(i, j))
        }
    }
}

//-- 7공주의 연결 여부 확인  --//
fun checkContinuous(girls: Array<Pos>): Boolean {
    val queue: Queue<Pos> = LinkedList()
    val visited = BooleanArray(7){false}
    queue.add(girls[0])
    visited[0] = true

    //bfs 체크
    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        //4방향
        for (d in 0 until 4) {
            val nx = cur.x + directX[d]
            val ny = cur.y + directY[d]

            if (nx !in 0 until 5 || ny !in 0 until 5)
                continue

            //방문 안했으면 포함
            for (i in 1 until 7) {
                if (!visited[i] && girls[i].x == nx && girls[i].y == ny) {
                    visited[i] = true
                    queue.add(Pos(nx, ny))
                    break
                }
            }
        }
    }

    return visited.all { it }
}
