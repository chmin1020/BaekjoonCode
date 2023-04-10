fun main() {
    //세팅
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val tc = br.readLine().toInt()

    //입력
    repeat(tc) {
        br.readLine()
        val money = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val m = br.readLine().toInt()
        val dp = IntArray(m + 1){ 0 }.also { it[0] = 1 }

        //dp 구하기
        for(coin in money)
            for(price in coin .. m)
                dp[price] += dp[price - coin]

        //출력
        bw.write("${dp[m]}\n")
    }

    bw.flush()
    bw.close()
}
