import java.util.LinkedList
import java.util.Queue

data class Pos(val x: Int, val y: Int)

const val DIRECT_CNT = 4
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    val answers = mutableListOf<Int>()
    repeat(tc) {
        //상수 입력
        val (h, w) = br.readLine().split(" ").map { it.toInt() }

        //맵 입력
        val map = Array(h + 2) { CharArray(w + 2) }

        map[0] = CharArray(w + 2){'.'}
        map[h + 1] = CharArray(w + 2){'.'}
        for (row in 1 until h + 1)
            map[row] = ".${br.readLine()}.".toCharArray()

        //키 입력
        val haveKey = BooleanArray(26) { false }
        br.readLine().forEach { each ->
            if(each.isKey()) haveKey[each.toIdx()] = true
        }

        //얻을 수 있는 키 모두 구하기
        while (true){
            val visited = Array(h + 2) { BooleanArray(w + 2) { false } }
            if(keyBfs(map, visited, haveKey, Pos(0, 0)) == 0)
                break
        }

        //가진 키로 bfs 진행
        val visited = Array(h + 2) { BooleanArray(w + 2) { false } }
        answers.add(documentBfs(map, visited, haveKey, Pos(0, 0)))
    }

    //출력
    println(answers.joinToString("\n"))
}

//-- 알파벳 관련 확장함수 --//
fun Char.isKey(): Boolean = this in 'a'..'z'
fun Char.isDoor(): Boolean = this in 'A'..'Z'
fun Char.isDocument(): Boolean = (this == '$')
fun Char.toIdx(): Int = (this.toLowerCase() - 'a')

//-- 이동이 가능한 곳 파악 --//
fun isPossibleRoute(route: Char, haveKey: BooleanArray): Boolean{
    if(route == '*')
        return false
    if(route.isDoor() && !haveKey[route.toIdx()])
        return false
    return true
}

//--bfs 통해 가능한 열쇠 얻기 --//
fun keyBfs(map: Array<CharArray>, visited: Array<BooleanArray>, haveKey: BooleanArray, start: Pos): Int{
    var keyCnt = 0

    val queue: Queue<Pos> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //4방향 탐색
        for(it in 0 until DIRECT_CNT){
            val nx = cur.x + directX[it]
            val ny = cur.y + directY[it]

            //맵 범위 벗어남
            if(nx !in map.indices || ny !in map[0].indices)
                continue

            //이미 방문했거나 이동 못하는 곳
            if(visited[nx][ny] || !isPossibleRoute(map[nx][ny], haveKey))
                continue

            //키 발견
            if(map[nx][ny].isKey()) {
                haveKey[map[nx][ny].toIdx()] = true
                map[nx][ny] = '.'
                keyCnt++
            }

            //새 경로로 고려
            visited[nx][ny] = true
            queue.add(Pos(nx, ny))
        }
    }
    return keyCnt
}


//-- bfs 통해 가능 문서 개수 구하기 --//
fun documentBfs(map: Array<CharArray>, visited: Array<BooleanArray>, haveKey: BooleanArray, start: Pos): Int {
    var docCnt = 0

    val queue: Queue<Pos> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //문서 발견
        if(map[cur.x][cur.y].isDocument()) {
            docCnt++
            map[cur.x][cur.y] = '.'
        }

        //4방향 탐색
        for(it in 0 until DIRECT_CNT){
            val nx = cur.x + directX[it]
            val ny = cur.y + directY[it]

            //맵 범위 벗어남
            if(nx !in map.indices || ny !in map[0].indices)
                continue

            //방문했거나 이동 못하는 곳
            if(visited[nx][ny] || !isPossibleRoute(map[nx][ny], haveKey))
                continue

            //새 경로로 고려
            visited[nx][ny] = true
            queue.add(Pos(nx, ny))
        }
    }
    return docCnt
}
