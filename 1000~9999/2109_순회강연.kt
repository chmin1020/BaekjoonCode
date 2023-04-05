import java.util.*

//많은 돈이 우선 순위인 요청 데이터 클래스
data class Request(val money: Int, val deadLine: Int): Comparable<Request>{
    override fun compareTo(other: Request): Int {
        return other.money - this.money
    }
}

const val NO_DAY = 0

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수
    val n = br.readLine().toInt()

    //배치 입력
    val heap = PriorityQueue<Request>()
    repeat(n){
        val (money, deadLine) = br.readLine().split(" ").map { it.toInt() }
        heap.add(Request(money, deadLine))
    }

    val answer = getAnswer(heap)

    //출력
    with(System.out.bufferedWriter()){
        write("${answer}\n")
        flush()
        close()
    }
}

//-- 요청 정보로 최대로 벌 수 있는 돈 구하기 --//
fun getAnswer(heap: PriorityQueue<Request>): Int{
    val restDay = IntArray(10001){ it }
    var total = 0

    while(heap.isNotEmpty()){
        val cur = heap.poll()

        val possibleDay = find(restDay, cur.deadLine)
        if(possibleDay == NO_DAY) continue //강연 실패
        total += cur.money //강연 성공
    }

    return total
}

//채울 수 있는 날짜 찾기
fun find(restDay: IntArray, req: Int): Int{
    //강연할 날 없음
    if(restDay[req] == NO_DAY)
        return NO_DAY

    //fresh 상태
    if(restDay[req] == req)
        return restDay[req]--

    restDay[req] = find(restDay, restDay[req])
    return restDay[req]
}
