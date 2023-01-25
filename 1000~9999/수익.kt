fun main() {
    //입력
    var cnt = (readLine() ?: "0").toInt()

    while(cnt != 0){
        val dp = LongArray(cnt)
        var answer = Long.MIN_VALUE

        //입력 받고 즉시 dp
        for(i in 0 until cnt){
            dp[i] = (readLine() ?: "").toLong()
            if(i > 0)
                dp[i] = maxOf(dp[i], dp[i - 1] + dp[i])
            answer = maxOf(answer, dp[i])
        }
        println(answer)

        //새로운 테스트케이스
        cnt = (readLine() ?: "0").toInt()
    }
}
