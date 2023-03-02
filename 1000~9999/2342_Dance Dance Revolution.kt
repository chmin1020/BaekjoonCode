import kotlin.math.abs

const val INF = 100000000
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    val orders = br.readLine().split(" ").map { it.toInt() }.filter { it != 0 }.toIntArray()

    //dp 설정
    val dp = Array(orders.size + 1){ Array(5) { IntArray(5){ INF } } }
    dp[0][0][0] = 0

    for(i in orders.indices){ //목적 발판
        for(j in 0 until 5){ //왼
            for(k in 0 until 5){ //오른
                if(dp[i][j][k] >= INF) continue

                val leftMove = calcCost(j, orders[i])
                val rightMove = calcCost(k, orders[i])

                dp[i + 1][orders[i]][k] = minOf(dp[i + 1][orders[i]][k], dp[i][j][k] + leftMove)
                dp[i + 1][j][orders[i]] = minOf(dp[i + 1][j][orders[i]], dp[i][j][k] + rightMove)
            }
        }
    }

    //최솟값 찾기
    var answer = INF
    for(i in 0 until 5)
        answer = minOf(answer, dp[dp.lastIndex][i].minByOrNull { it } ?: INF)

    //출력
    println(answer)
    br.close()
}

//-- 문제 설명에 따른 코스트 계산값 반환 --//
fun calcCost(start: Int, end: Int): Int{
    return when{
        (start == end) -> 1
        (start == 0) -> 2
        (abs(start - end) == 2) -> 4
        else -> 3
    }
}
