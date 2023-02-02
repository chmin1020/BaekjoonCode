var answer = 0

fun main() {
    //입력
    val (lowLimit, highLimit) = (readLine() ?: "0 0").split(" ").map { it.toInt() }

    //체크
    findPossibles(lowLimit..highLimit, highLimit.toString().length, "")

    //출력
    println(answer)
}

//dfs 형식으로 가능한 숫자 조합 찾기
val twoNumbers = charArrayOf('4', '7')
fun findPossibles(range: IntRange, limitLen: Int, cur: String){
    if(cur.length > limitLen)
        return

    if(cur.isNotBlank() && cur.toLong() in range) answer++

    for(addNum in twoNumbers)
        findPossibles(range, limitLen, cur + addNum)
}
