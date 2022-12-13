fun main() {
    //입력 받기
    val num = (readLine() ?: "0").toInt()
    val mats = Array(num){IntArray(2)}

    for(i in 0 until num) {
        val each = (readLine() ?: "").split(" ").map{it.toInt()}.toIntArray()
        mats[i][0] = each[0]
        mats[i][1] = each[1]
    }

    //dp
    val dp = Array(num){IntArray(num){0} }
    val lastN = num - 1
    for(i in 1..num){
        for(start in 0 until num - i){
            val end = start + i

            //[start, point] * [point + 1, end]의 행렬곱 경우의 수 모두 측정
            var bestCase = Int.MAX_VALUE
            for(point in start until end){
                val numMulti = mats[start][0] * mats[point][1] * mats[end][1]
                val thisCase = dp[lastN - point][start] + dp[lastN - end][point + 1] + numMulti
                bestCase = minOf(bestCase, thisCase)
            }
            dp[lastN - end][start] = bestCase
        }
    }

    //출력
    println(dp[0][0])
}
