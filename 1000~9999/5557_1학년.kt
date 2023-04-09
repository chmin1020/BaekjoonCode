fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val answer = calculateDp(n, seq)

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}

//-- dp 계산 함수 --//
fun calculateDp(n: Int, seq: IntArray): Long {
    val dp = Array(n){ LongArray(21){ 0 } }

    dp[0][seq[0]] = 1
    for(idx in 1 until dp.lastIndex){
        for(prev in 0..20){
            if(dp[idx - 1][prev] > 0 && prev - seq[idx] >= 0)
                dp[idx][prev - seq[idx]] += dp[idx - 1][prev]
            if(dp[idx - 1][prev] > 0 && prev + seq[idx] <= 20)
                dp[idx][prev + seq[idx]] += dp[idx - 1][prev]
        }
    }

    return dp[n - 2][seq.last()]
}
