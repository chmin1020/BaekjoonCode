fun main(){
    //입력
    val (n, m) = (readLine() ?: "0 0").split(" ").map { it.toInt() }
    val memories = ("0 " + (readLine() ?: "")).split(" ").map { it.toInt() }.toIntArray()
    val costs = ("0 " + (readLine() ?: "")).split(" ").map { it.toInt() }.toIntArray()

    //연산에 필요한 값 미리 저장
    val totalCost = costs.sum() //전체를 비활성화할 시 비용

    //dp 연산
    val dp = Array(n + 1){IntArray(totalCost + 1){0} }
    var usedCost = Int.MAX_VALUE

    for(idx in 1 .. n){
        //사용하지 않는 비용 -> 커질수록 좋음
        for(cost in 0 .. totalCost){
            //앱을 유지할 경우
            dp[idx][cost] = dp[idx - 1][cost]

            //앱을 비활성화할 경우
            if(cost >= costs[idx]){
                val newValue = dp[idx - 1][cost - costs[idx]] + memories[idx]
                dp[idx][cost] = maxOf(dp[idx][cost], newValue)
            }

            //메모리 공간 확보를 성공했다면 사용 비용 최솟값 갱신
            if(dp[idx][cost] >= m)
                usedCost = minOf(usedCost, cost)
        }
    }

    //출력
    println(usedCost)
}
