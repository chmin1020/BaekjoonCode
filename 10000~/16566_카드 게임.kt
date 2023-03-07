lateinit var possibleCardIdxs: IntArray

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    //카드 입력
    val cards = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    cards.sort()

    //철수 카드 입력
    val turns = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    //각 자리의 현재 제출 가능 카드 설정
    possibleCardIdxs = IntArray(m) {it}

    //과정 실행 및 출력
    turns.forEach { println(simulation(cards, it)) }
}

//-- 카드 게임 시뮬레이션 --//
fun simulation(cards: IntArray, turn: Int): Int{
    var start = 0
    var end = cards.size - 1
    var bestIdx = 0

    //이분 탐색 통한 최고의 카드 자리 선정
    while (start <= end){
        val mid = (start + end) / 2

        if(cards[mid] > turn){
            bestIdx = mid
            end = mid - 1
        }
        else
            start = mid + 1
    }

    //선정된 카드 자리에서 낼 수 있는 베스트 카드 반환
    return cards[find(bestIdx)]
}

//-- 파인드 --//
fun find(idx: Int): Int {
    var res = idx
    if(idx == possibleCardIdxs[idx]){
        //적합한 카드(위치가 그대로인 카드) 사용 및 새로운 적합 카드로 갱신
        var nextPossible = idx + 1
        while (nextPossible < possibleCardIdxs.size && nextPossible != possibleCardIdxs[nextPossible])
            nextPossible++
        possibleCardIdxs[idx] = nextPossible
    }
    else {
        possibleCardIdxs[idx] = find(possibleCardIdxs[idx])
        res = possibleCardIdxs[idx]
    }

    return res
}
