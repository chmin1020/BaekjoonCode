import kotlin.math.min

const val INF = 300001

fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()

    //dp, 삼각형 수 배열 생성
    val dp = IntArray(n + 1){INF}
    val triangles = mutableListOf<Int>()

    //삼각형 수와 기본 dp 부터 채우기
    var defaultNum = 1
    var addNumber = 3
    var increased = 3

    while (defaultNum <= n){
        triangles.add(defaultNum)
        dp[defaultNum] = 1
        defaultNum += addNumber
        addNumber += increased++
    }

    //dp 채우기
    for(i in dp.indices){
        triangles.forEach {
            if(i >= it)
            dp[i] = min(dp[i], dp[i - it] + 1)
        }
    }

    //출력
    println(dp[n])
}
