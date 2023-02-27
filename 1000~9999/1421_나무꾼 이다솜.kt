fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, c, w) = br.readLine().split(" ").map { it.toInt() }

    //통나무 입력
    val logs = IntArray(n)
    for(idx in logs.indices)
        logs[idx] = br.readLine().toInt()

    //최대 확인하기
    var answer = 0L
    for(len in 1 .. (logs.maxByOrNull { it } ?: logs[0]))
        answer = maxOf(answer, possiblePrice(logs, len, c, w))

    //출력
    println(answer)
    br.close()
}

//-- 가능한 가격 계산 --//
fun possiblePrice(logs: IntArray, len: Int, c: Int, w: Int): Long{
    var total = 0L
    logs.forEach {
        val subLogCnt = it / len
        val cutCnt = subLogCnt - if(it % len == 0) 1 else 0

        //잘라서 넣는게 이득인 경우
        val curPrice = (len * subLogCnt * w - c * cutCnt)

        //통나무 하나에서 나오는 토막 값 - 자르는 값
        if(curPrice > 0)
            total += curPrice
    }
    return total
}
