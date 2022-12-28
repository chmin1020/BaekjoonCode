fun main() {
    //입력 받고 정보 채우기
    val nm = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()
    val cardCnt = IntArray(nm[0]){0} //박스 당 카드 개수
    val info = Array(nm[0]){IntArray(nm[1])}
    for(i in 0 until nm[0]){
        val input = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()
        for(j in 0 until nm[1]) {
            info[i][j] = input[j]
            if(input[j] != 0) cardCnt[i]++
        }
    }

    //모든 박스를 조커로 두고 경우의 수 체크
    var answer = Int.MAX_VALUE
    for(jokerBox in 0 until nm[0]){
        var moveCnt = 0
        val checked = BooleanArray(nm[1]){false}
        for(eachBox in 0 until nm[0]){
            if(jokerBox == eachBox)
                continue
            else if(cardCnt[eachBox] == 0)
                continue
            else if(cardCnt[eachBox] > 1)
                moveCnt++
            else{ //카드 개수가 1인 경우만 특별히 움직임 체크 필요함 (카드 종류)
                var card = 0
                while(info[eachBox][card] == 0) card++

                if(checked[card]) moveCnt++
                else checked[card] = true
            }
        }
        answer = minOf(answer, moveCnt)
    }
    println(answer)
}
