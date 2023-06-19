
const val MOD_NUM = 1000000
fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val dates = br.readLine().toInt()

    //날짜, 지각( < 2), 결석 연속( < 3)
    val dp = Array(dates + 1){ Array(2){ IntArray(3){0}}}


    //첫날 가능성
    dp[1][0][0] = 1
    dp[1][1][0] = 1
    dp[1][0][1] = 1

    //dp 계산
    for(i in 2 until dp.size){
        dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD_NUM
        dp[i][0][1] = dp[i - 1][0][0] % MOD_NUM
        dp[i][0][2] = dp[i - 1][0][1] % MOD_NUM
        dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD_NUM
        dp[i][1][1] = dp[i - 1][1][0] % MOD_NUM
        dp[i][1][2] = dp[i - 1][1][1] % MOD_NUM
    }

    val answer =
        (dp[dates][0][0] + dp[dates][0][1] + dp[dates][0][2] + dp[dates][1][0] + dp[dates][1][1] + dp[dates][1][2]) % MOD_NUM

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}
