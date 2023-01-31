import java.util.*

val directRow = intArrayOf(-1, 1, 0, 0)
val directCol = intArrayOf(0, 0, -1, 1)

data class Pos(val row: Int, val col: Int)
data class UnionInfo(val set: Set<Pos>, val peopleCnt: Int)

fun main() {
    //입력
    val (n, l, r) = (readLine()?:"0 0 0").split(" ").map { it.toInt() }

    val map = Array(n){IntArray(n){0}}
    for(i in 0 until n)
        map[i] = (readLine()?:"").split(" ").map { it.toInt() }.toIntArray()

    //판별
    val unions = mutableSetOf<UnionInfo>()


    //-------------------------//

    //--bfs 내에서 사용할 판별 함수--//
    fun isUnionPossible(cnt1: Int, cnt2: Int): Boolean{
        val diff = if(cnt1 > cnt2) cnt1 - cnt2 else cnt2 - cnt1
        return (diff in l..r)
    }

    //----판별에 쓰일 bfs 함수----//
    fun bfs(pos: Pos, checked: Array<BooleanArray>): UnionInfo? {
        var peopleTotal = 0
        val unionArea = mutableSetOf<Pos>()

        //큐 세팅
        val qu:Queue<Pos> = LinkedList()
        qu.add(pos)
        checked[pos.row][pos.col] = true

        //큐 빌 때까지 bfs
        while (qu.isNotEmpty()){
            val cur = qu.poll()
            peopleTotal += map[cur.row][cur.col]
            unionArea.add(cur)

            //방향 체크
            for(directIdx in 0 until 4){
                val nRow = cur.row + directRow[directIdx]
                val nCol = cur.col + directCol[directIdx]

                if(nRow in 0 until n && nCol in 0 until n //범위 충족
                    && isUnionPossible(map[cur.row][cur.col], map[nRow][nCol]) //조건 충족
                    && !checked[nRow][nCol]) { //미연합 충족
                    checked[nRow][nCol] = true
                    qu.add(Pos(nRow, nCol))
                }
            }
        }

        //연합 국가가 2개 이상일 시 정보 반환
        return if(unionArea.size > 1) UnionInfo(unionArea, peopleTotal) else null
    }

    //-------------------------//


    var cnt = 0
    var allDone = false
    while(!allDone){
        val checked = Array(n){BooleanArray(n){false} }
        unions.clear()

        //연합 찾기
        for(i in 0 until n)
            for(j in 0 until n)
                if(!checked[i][j])
                    bfs(Pos(i, j), checked)?.let { unions.add(it) }

        //연합 인구 수 갱신
        unions.forEach {
            val newPeopleCnt = it.peopleCnt / it.set.size
            it.set.forEach { eachLand-> map[eachLand.row][eachLand.col] = newPeopleCnt }
        }

        allDone = unions.isEmpty().also { if(!it) cnt++ }
     }

    //출력
    println(cnt)
}
