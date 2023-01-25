fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()
    val prices = (readLine() ?: "").split(" ").map{ it.toInt() }.toTypedArray()
    var m = (readLine() ?: "0").toInt()

    var cheapIdx = 0
    prices.forEachIndexed { idx, it -> if(prices[cheapIdx] >= it) cheapIdx = idx }

    val tmpList = mutableListOf<Int>()

    //만약 제일 작은 게 0이면 다른 것부터 구매 시도
    if(cheapIdx == 0 && n > 1){
        var nextCheapIdx = 1
        for(i in 1 until n)
            if(prices[nextCheapIdx] >= prices[i])
                nextCheapIdx = i

        if(m >= prices[nextCheapIdx]){
            tmpList.add(nextCheapIdx)
            m -= prices[nextCheapIdx]
        }
    }

    //제일 싼 것부터 순서대로 사기
    while(m - prices[cheapIdx] >= 0) {
        tmpList.add(cheapIdx)
        m -= prices[cheapIdx]
    }

    //카드 순열 배열에 저장 (인덱스 접근 위해)
    val result = tmpList.toIntArray()

    //높은 자리부터 큰 숫자로 교체 시도
    var pricePtr = prices.size - 1
    var cardPtr = 0

    while(pricePtr > 0 && cardPtr < result.size){
        //0이 아닌 카드였으면 다음도 체크 시도
        if(pricePtr == result[cardPtr]){
            cardPtr++
            continue
        }

        //교체 가능하면 교체
        if(m + prices[result[cardPtr]] >= prices[pricePtr]){
            m = m + prices[result[cardPtr]] - prices[pricePtr]
            result[cardPtr++] = pricePtr
        }
        else
            pricePtr--
    }

    //출력
    if(result.all { it == 0 })
        println(0)
    else{
        result.forEach { print(it) }
        println()
    }
}
