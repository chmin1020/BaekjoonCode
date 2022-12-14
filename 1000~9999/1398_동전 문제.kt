//10과 1을 통한 처리
fun withTenAndOne(num: Int): Int = num % 10 + num / 10

fun main() {
    //입력 받기
    val caseCnt = (readLine()?:"0").toInt()

    //1~100 dp 채우기
    val dp = IntArray(100){Int.MAX_VALUE}
    dp[0] = 0
    for(i in 1 until 100) {
        if (i < 25)
            dp[i] = i % 10 + i / 10
        else {
            var tmp = i
            var step = 0
            while (tmp >= 0) {
                dp[i] = minOf(dp[i], (step++) + withTenAndOne(tmp))
                tmp -= 25
            }
        }
    }

    //테스트 케이스 돌리기
    for(i in 0 until caseCnt){
        var target = (readLine() ?: "0").toLong()
        var answer = 0L

        // 100씩 나누면서 dp로 해결
        while(target > 0){
            answer += dp[(target % 100).toInt()]
            target /= 100
        }
        println(answer)
    }
}
