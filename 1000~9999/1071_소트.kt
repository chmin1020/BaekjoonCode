import java.util.*

data class NumInfo(val value: Int, val cnt: Int) : Comparable<NumInfo> {
    override fun compareTo(other: NumInfo): Int {
        return this.value - other.value
    }
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //정렬할 배열
    val cntMap = mutableMapOf<Int, Int>()
    val sortHeap = PriorityQueue<NumInfo>()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    //각 숫자의 개수 별로 그룹을 짓고 heap 저장
    numbers.forEach { cntMap[it] = (cntMap[it] ?: 0) + 1 }
    cntMap.forEach { (value, cnt) ->
        sortHeap.add(NumInfo(value, cnt))
    }

    //조건에 맞게 배열 출력하는 작업
    while (sortHeap.isNotEmpty()) {
        val cur = sortHeap.poll()

        if (sortHeap.isEmpty()) //이거만 남았으면 바로 출력
            repeat(cur.cnt) { print("${cur.value} ") }
        else {
            //뒤 숫자와 연속됨
            if (cur.value + 1 == sortHeap.peek().value) {
                if (sortHeap.size >= 2) { //다음 수가 2개 이상
                    //지금꺼는 바꿀 필요 없는 것 확실 -> 그냥 출력
                    repeat(cur.cnt) { print("${cur.value} ") }

                    val next1 = sortHeap.poll()
                    val next2 = sortHeap.poll()

                    //3번째 연속 값을 1개 출력
                    print("${next2.value} ")

                    //나머지는 그대로 다시 힙에 넣기
                    sortHeap.add(next1)
                    if(next2.cnt > 1)
                        sortHeap.add(NumInfo(next2.value, next2.cnt - 1))

                } else { //다음 수가 단 1개 -> 둘 순서 바꿔서 출력
                    val next = sortHeap.poll()

                    repeat(next.cnt) { print("${next.value} ") }
                    repeat(cur.cnt) { print("${cur.value} ") }
                }
            }
            else //연속 안되면 바로 출력
                repeat(cur.cnt) { print("${cur.value} ") }
        }
    }

    br.close()
}
