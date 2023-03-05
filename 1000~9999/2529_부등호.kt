var minAns = ""
var maxAns = ""

val chars = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
val checked = BooleanArray(10){false}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //부등호 입력
    val signs = br.readLine().split(" ").map { it[0] }.toCharArray()

    //백트래킹 탐색
    val sb = StringBuilder()
    for((idx,c) in chars.withIndex()){
        sb.append(c)
        checked[idx] = true
        backtracking(signs, n, sb, 0)
        sb.deleteAt(sb.lastIndex)
        checked[idx] = false
    }

    //출력
    println("$maxAns\n$minAns")
}

//-- 백트래킹 --//
fun backtracking(signs: CharArray, n: Int, curSb: StringBuilder, curIdx: Int){
    //끝
    if(curIdx == n){
        val finalStr = curSb.toString()
        if(minAns.isBlank() || minAns > finalStr)
            minAns = finalStr
        if(maxAns.isBlank() || maxAns < finalStr)
            maxAns = finalStr
        return
    }

    //모든 숫자 가능성 탐색
    val curSign = signs[curIdx]
    chars.forEachIndexed { idx, c ->
        if(!checked[idx]){
            //부등호 조건 만족
            if((curSign == '<' && curSb[curIdx] < c) || (curSign == '>' && curSb[curIdx] > c)){
                curSb.append(c)
                checked[idx] = true
                backtracking(signs, n, curSb, curIdx + 1)
                curSb.deleteAt(curSb.lastIndex)
                checked[idx] = false
            }
        }
    }
}
