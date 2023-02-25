const val LIMIT = 1000000000

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //n 입력
    val n = br.readLine().toInt()

    var answer = 0L

    if(n >= 10){
        //dp 채우기
        val dp = Array(n + 1){ Array(10) { LongArray(1024){ 0 } } }
        for(i in 1 until 10)
            dp[1][i][(1 shl i)] = 1

        for(len in 2 .. n){
            for(endNum in 0 until 10){
                val bitCheck = (1 shl endNum)

                for(bit in 1 until 1024){
                    if(endNum != 0)
                        dp[len][endNum][bit or bitCheck] = (dp[len][endNum][bit or bitCheck] + dp[len - 1][endNum - 1][bit]) % LIMIT

                    if(endNum != 9)
                        dp[len][endNum][bit or bitCheck] = (dp[len][endNum][bit or bitCheck] + dp[len - 1][endNum + 1][bit]) % LIMIT
                }
            }
        }

        //dp 다 합쳐서 출력
        for(i in 0 until 10)
            answer = (answer + dp[n][i][1023]) % LIMIT
    }

    //출력
    println(answer)
    br.close()
}
