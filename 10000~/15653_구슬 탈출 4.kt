const val INF = 100000000
const val DIRECT_CNT = 4
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

data class Pos(val x: Int = -1, val y: Int = -1)
data class Game(val red: Pos, val blue: Pos, val hole: Pos)

lateinit var visited: Array<Array<Array<IntArray>>>

var answer = Int.MAX_VALUE
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //보드 입력
    val board = Array(n) { CharArray(m) }
    repeat(n) {
        board[it] = br.readLine().toCharArray()
    }

    visited = Array(n) { Array(m) { Array(n) { IntArray(m) { INF } } } }

    //구슬과 구멍 위치 파악
    var red = Pos()
    var blue = Pos()
    var hole = Pos()
    for (i in 0 until n) {
        for (j in 0 until m) {
            when (board[i][j]) {
                'R' -> red = Pos(i, j)
                'B' -> blue = Pos(i, j)
                'O' -> hole = Pos(i, j)
            }
        }
    }
    val gameStat = Game(red, blue, hole)

    //시뮬레이션 돌리기
    simulation(board, gameStat, 1)

    //출력
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

//-- 각 상황에 따른 구슬 시뮬레이션 --//
fun simulation(board: Array<CharArray>, gameStat: Game, cnt: Int) {
    if (visited[gameStat.blue.x][gameStat.blue.y][gameStat.red.x][gameStat.red.y] <= cnt || answer <= cnt) return
    visited[gameStat.blue.x][gameStat.blue.y][gameStat.red.x][gameStat.red.y] = cnt

    for (it in 0 until DIRECT_CNT) {
        //새 위치 구하기 작업
        var newBlue = moveByGravity(board, gameStat.blue, it)
        var newRed = moveByGravity(board, gameStat.red, it)

        //순서에 따라 red, blue 재조정
        if (newBlue == newRed && newBlue != gameStat.hole) {
            if (whatWasFollowed(gameStat, it) == 'R') newRed = Pos(newRed.x - directX[it], newRed.y - directY[it])
            else newBlue = Pos(newBlue.x - directX[it], newBlue.y - directY[it])
        }

        //파랑 구슬이 빠짐 -> 더 볼 필요 x
        if (newBlue == gameStat.hole) continue

        //빨간 구슬이 빠짐 -> 게임 성공
        if (newRed == gameStat.hole) {
            answer = minOf(answer, cnt)
            return
        }

        //재귀로 다음 시뮬레이션
        simulation(board, Game(newRed, newBlue, gameStat.hole), cnt + 1)
    }
}

//-- 같은 선 상에 R, B 중 뭐가 뒷구술이었는지 판별 --//
fun whatWasFollowed(gameStat: Game, d: Int): Char {
    return when (d) {
        0 -> {
            if (gameStat.red.x > gameStat.blue.x) 'R'
            else 'B'
        }

        1 -> {
            if (gameStat.red.x < gameStat.blue.x) 'R'
            else 'B'
        }

        2 -> {
            if (gameStat.red.y > gameStat.blue.y) 'R'
            else 'B'
        }

        else -> {
            if (gameStat.red.y < gameStat.blue.y) 'R'
            else 'B'
        }
    }
}

//-- 이동 --//
fun moveByGravity(board: Array<CharArray>, cur: Pos, d: Int): Pos {
    var newX = cur.x
    var newY = cur.y

    while (true) {
        val nx = newX + directX[d]
        val ny = newY + directY[d]

        //벽 이전에서 멈춤
        if (board[nx][ny] == '#') break

        //이동
        newX = nx
        newY = ny

        //구멍에 빠졌으면 멈춤
        if (board[nx][ny] == 'O') break
    }

    return Pos(newX, newY)
}
