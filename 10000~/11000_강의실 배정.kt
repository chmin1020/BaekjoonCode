import java.util.*

//예약 시간 데이터 클래스
data class TimeRange(val start: Int, val end: Int) : Comparable<TimeRange> {
    override fun compareTo(other: TimeRange) = this.end - other.end
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //강의 예약 시간 입력
    val timeList = mutableListOf<TimeRange>()
    for(i in 0 until n){
        val st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        timeList.add(TimeRange(start, end))
    }
    timeList.sortBy { it.start }

    //강의실 배정 시작
    var roomCnt = 0
    val usingRooms = PriorityQueue<TimeRange>()
    timeList.forEach {
        //현재 시간 예약할당시간이 끝난 방은 빼기
        while(usingRooms.isNotEmpty() && usingRooms.peek().end <= it.start)
            usingRooms.poll()

        //방을 다 쓰고 있으면 새 방 추가
        if(roomCnt == usingRooms.size)
            roomCnt++

        //방 할당
        usingRooms.add(it)
    }

    //출력
    println(roomCnt)
    br.close()
}
