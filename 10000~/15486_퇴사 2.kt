data class Counsel(val period:Int = 0, val price:Int = 0)

fun main() {
    //세팅
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    //입력
    val n = br.readLine().toInt()
    val arr = Array(n + 1){Counsel()}
    repeat(n){
        val (period, price) = br.readLine().split(" ").map { it.toInt() }
        arr[it] = Counsel(period, price)
    }

    //dp
    val dp = IntArray(n + 1){ 0 }
    for(day in n - 1 downTo 0){
        dp[day] = dp[day + 1]
        if(day + arr[day].period <= n)
            dp[day] = maxOf(dp[day + 1], arr[day].price + dp[day + arr[day].period])
    }

    //출력
    with(bw){
        write("${dp[0]}\n")
        flush()
        close()
    }
}
