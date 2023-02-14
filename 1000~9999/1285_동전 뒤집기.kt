fun main() {
    //관련 수 입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    //맵 입력
    val coins = Array(n){IntArray(n)}
    for(i in 0 until n) {
        br.readLine().forEachIndexed { index, c ->
            coins[i][index] = if(c == 'T') 1 else 0
        }
    }

    //for 구문으로 모든 열 뒤집기 계산
    var answer = Int.MAX_VALUE
    for(flipSituation in 0 until twoPower(n))
        answer = minOf(answer, makeSituationMap(coins, flipSituation))

    //출력
    println(answer)
    br.close()
}

//-- 2의 제곱 구하는 함수 --//
fun twoPower(n: Int) = (0 until n).fold(1){ res, _ -> res * 2}

//-- flip 개수에 따른 맵 상태를 만드는 함수 --//
fun makeSituationMap(coins: Array<IntArray>, flips: Int): Int{
    //비트마스킹을 통한 뒤집기 여부 체크
    var res = 0

    //뒤집는 상황이면 뒤집어서, 아니면 제대로 세기
    for(i in coins.indices){
        var tail = 0
        for(j in coins.indices)
            tail += if(((1).shl(j)).and(flips) != 0) 1 - coins[j][i] else coins[j][i]

        res += minOf(tail, coins.size - tail)
    }
    return res
}
