fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()
    val countTable = mutableMapOf<Int, Int>()

    //배열 입력
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for(num in arr)
        countTable[num] = (countTable[num] ?: 0) + 1

    //답 구하기
    val answer = getAnswer(n, countTable, arr)

    //출력
    with(System.out.bufferedWriter()){
        write(answer.joinToString(" "))
        flush()
        close()
    }
}

//-- 정답 구하기 --//
fun getAnswer(n: Int, countTable: Map<Int, Int>, arr: IntArray): IntArray {
    val res = IntArray(n){ -1 }
    val dp = IntArray(n){ -1 }

    for(idx in n - 2 downTo 0){
        var ptr = idx + 1
        while(ptr != -1){
            //값을 만족 하면 오등큰수
            if((countTable[arr[idx]] ?: 0) < (countTable[arr[ptr]] ?: 0)){
                res[idx] = arr[ptr]
                dp[idx] = ptr //dp에는 현재 기준 오등큰수의 색인을 기입
                break
            }
            ptr = dp[ptr]
        }
    }

    return res
}
