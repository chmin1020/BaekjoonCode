var cnt = Int.MAX_VALUE
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val paper = Array(10){IntArray(10) }
    repeat(10){idx ->
        paper[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val oneLeftCnt = paper.fold(0){ tot, it -> tot + it.count { each -> each == 1 }}

    doPaperBruteForce(paper, oneLeftCnt)

    //출력
    with(System.out.bufferedWriter()){
        write("${if(cnt == Int.MAX_VALUE) -1 else cnt}\n")
        flush()
        close()
    }
}

//-- 색종이 개수 브루트포스 --//
fun doPaperBruteForce(paper: Array<IntArray>, oneLeftCnt: Int){
    val rest = IntArray(6){5}
    backtracking(paper, rest, 0, -1, 0, oneLeftCnt)
}

//-- 백트래킹 dfs --//
fun backtracking(paper:Array<IntArray>, rest:IntArray, px: Int, py: Int, curCnt: Int, oneLeftCnt: Int){
    //볼 필요 없음
    if(cnt <= curCnt)
        return

    //조건 만족
    if(oneLeftCnt == 0){
        cnt = curCnt
        return
    }

    for(x in px until 10){
        for(y in 0 until 10){
            if(px == x && py > y) continue

            if(paper[x][y] == 1){
                for(len in 5 downTo  1){
                    if(rest[len] == 0) continue
                    if(checkArea(paper, x, y, len)){
                        fillHoles(paper, x, y, len, 0)
                        rest[len]--
                        backtracking(paper, rest, x, y, curCnt + 1, oneLeftCnt - len * len)
                        rest[len]++
                        fillHoles(paper, x, y, len, 1)
                    }
                }
                return
            }
        }
    }
}

//-- 색종이 쓸 수 있는지 확인 --//
fun checkArea(paper:Array<IntArray>, sx: Int, sy: Int, len: Int): Boolean{
    if(sx + len > 10 || sy + len > 10)
        return false

    for(i in sx until sx + len)
        for(j in sy until sy + len)
            if(paper[i][j] != 1) return false
    return true
}

//-- 색종이로 덮기 --//
fun fillHoles(paper: Array<IntArray>, sx: Int, sy: Int, len: Int, value: Int){
    for(i in sx until minOf(10, sx + len))
        for(j in sy until minOf(10, sy + len))
            paper[i][j] = value
}
