val dp = IntArray(10000001){0}.also { it[0] = 1; it[1] = 1 }

fun fibonacci(n: Int): Int{
    if(dp[n] == 0)
        dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 10
    return dp[n]
}

fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()
    println(fibonacci(n))
}
