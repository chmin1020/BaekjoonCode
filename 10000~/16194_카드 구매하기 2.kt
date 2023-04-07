fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    val n = br.readLine().toInt()
    val prices = ("0 " + br.readLine()).split(" ").map { it.toInt() }.toIntArray()

    //답 구하기
    val answer = getAnswer(n, prices)

    //출력
    with(System.out.bufferedWriter()){
        write("$answer\n")
        flush()
        close()
    }
}

//-- dp 통한 답 구하기 --//
fun getAnswer(n: Int, prices: IntArray): Int{
    val dp = IntArray(n + 1){ 10000000 }
    dp[0] = prices[0]

    for(cnt in 1 .. n)
        for(tmp in 1 .. cnt) //이번에 사려는 카드
            dp[cnt] = minOf(dp[cnt], prices[tmp] + dp[cnt - tmp])
    return dp[n]
}
