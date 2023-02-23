var answer = 4

data class Pos(val row: Int, val col: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (n, m, h) = br.readLine().split(" ").map { it.toInt() }

    //사다리 기존 가로선 입력
    val ladders = Array(n) { BooleanArray(h) { false } }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
        ladders[b][a] = true
    }

    //설치 가능 구역만 분류
    val candidates = mutableListOf<Pos>()
    for (i in 0 until n - 1)
        for (j in 0 until h)
            if (!ladders[i][j])
                candidates.add(Pos(i, j))

    //모든 케이스 테스트 수행
    setLadderCase(ladders, candidates.toTypedArray(), 0, 0)

    //출력
    println(if (answer == 4) -1 else answer)
    br.close()
}

//-- dfs 통한 사다리 가능 케이스 탐색 --//
fun setLadderCase(ladders: Array<BooleanArray>, candidates: Array<Pos>, idx: Int, cnt: Int) {
    //새 답의 가능성이 없으면 볼 필요 없음
    if (cnt > minOf(3, answer)) return

    //가능성 체크
    if (testLadders(ladders)) {
        answer = cnt
        return
    }

    //사다리 가로 채우기
    for (i in idx until candidates.size) {
        //더 해봐야 답이 새로 나오지 않음
        if(cnt + 1 >= answer)
            break

        val cur = candidates[i]

        //연속된 부분에서 이미 채워져 있다면 채우기 불가
        if (candidates[i].row > 0 && ladders[candidates[i].row - 1][candidates[i].col]) continue
        if (candidates[i].row < ladders.lastIndex - 1 && ladders[candidates[i].row + 1][candidates[i].col]) continue

        //다음 사다리 칸으로
        ladders[candidates[i].row][candidates[i].col] = true
        setLadderCase(ladders, candidates, i + 1, cnt + 1)
        ladders[candidates[i].row][candidates[i].col] = false
    }
}

//-- 현재 사다리 상태에서 통과가 되는지 체크 --//
fun testLadders(ladders: Array<BooleanArray>): Boolean {
    for (start in ladders.indices) {
        var curRow = start
        for (col in ladders[0].indices) {
            if (curRow > 0 && ladders[curRow - 1][col]) //왼쪽 이동
                curRow--
            else if (curRow < ladders.lastIndex && ladders[curRow][col]) //오른쪽 이동
                curRow++
        }

        //도착지가 처음 row 아니면 실패
        if (curRow != start)
            return false
    }
    return true
}
