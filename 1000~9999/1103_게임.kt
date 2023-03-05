const val NOT_CHECK = -1
const val INF = 10000000
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //맵 입력
    val dp = Array(n) { IntArray(m) { NOT_CHECK } }
    val board = Array(n) { CharArray(m) }
    for(idx in 0 until n)
        board[idx] = br.readLine().toCharArray()

    //보드 탐색
    val answer =  dfs(board, dp, Pos(0, 0), Array(n){BooleanArray(m)})

    //출력
    println(if(answer > INF) -1 else answer)
}

const val DIRECT_CNT = 4
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1 ,1)

data class Pos(val x: Int, val y: Int)

//-- dfs --//
fun dfs(board: Array<CharArray>, dp: Array<IntArray>, cur: Pos, checked: Array<BooleanArray>): Int{
    //보드를 벗어났으면 끝
    if(cur.x !in board.indices || cur.y !in board[0].indices)
        return 0

    //구멍에 떨어졌으면 끝
    if(board[cur.x][cur.y] == 'H')
        return 0

    //순환 가능한 상황이 존재
    if(checked[cur.x][cur.y])
        return INF

    //이미 확인해봤음
    if(dp[cur.x][cur.y] != NOT_CHECK)
        return dp[cur.x][cur.y]

    dp[cur.x][cur.y] = 0
    checked[cur.x][cur.y] = true
    //4방향 체크
    for(d in 0 until DIRECT_CNT){
        val nx = cur.x + (board[cur.x][cur.y] - '0') * directX[d]
        val ny = cur.y + (board[cur.x][cur.y] - '0') * directY[d]

        //이동 시도
        dp[cur.x][cur.y] = maxOf(dp[cur.x][cur.y], dfs(board, dp, Pos(nx, ny), checked) + 1)
    }
    checked[cur.x][cur.y] = false

    return dp[cur.x][cur.y]
}
