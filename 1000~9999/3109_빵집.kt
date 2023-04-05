data class Pos(val x: Int, val y: Int)
val directX = intArrayOf(-1, 0, 1)

var cnt = 0
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //배치 입력
    val map = Array(n){CharArray(m)}
    repeat(n){ map[it] = br.readLine().toCharArray() }

    //dfs 시작
    val visited = Array(n){ BooleanArray(m){false} }
    for(row in 0 until n)
        dfs(map, visited, Pos(row, 0), row, 0)

    //출력
    with(System.out.bufferedWriter()){
        write("${cnt}\n")
        flush()
        close()
    }
}

//-- dfs 통해 길 찾기 --//
fun dfs(batch: Array<CharArray>,visited: Array<BooleanArray>, cur: Pos, startRow: Int, total: Int): Boolean{
    //파이프 연결 완료
    if(cur.y == batch[0].lastIndex){
        cnt++
        return true
    }

    //세 갈래 탐색
    for(d in 0 until 3){
        val nx = cur.x + directX[d]
        val ny = cur.y + 1

        //범위 제한, 벽이나 설치된 곳
        if(nx !in batch.indices) continue
        if(visited[nx][ny] || batch[nx][ny] == 'x') continue

        //최대한 상향 방향으로 가는 경로 찾으면 밑에는 볼 필요 없음
        visited[nx][ny] = true
        if(dfs(batch, visited, Pos(nx, ny), startRow, total))
            return true
    }
    return false
}
