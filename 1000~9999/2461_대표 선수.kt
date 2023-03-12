import java.util.*

data class PtrInfo(val idx: Int, val value: Int): Comparable<PtrInfo>{
    override fun compareTo(other: PtrInfo): Int {
        return this.value - other.value
    }
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //학급 능력치 저장
    val classes = Array(n){ IntArray(m) }
    val ptr = IntArray(n){0}
    repeat(n){idx ->
        classes[idx] = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
        classes[idx].sort()
    }

    //각 반의 현재 포인터 상황 저장
    val minHeap = PriorityQueue<PtrInfo>()
    var maxVal = 0
    for(i in 0 until n) {
        minHeap.add(PtrInfo(i, classes[i][0]))
        maxVal = maxOf(classes[i][0], maxVal)
    }

    //힙을 이용한 답 계산
    var answer = Int.MAX_VALUE
    while (minHeap.size == n){
        answer = minOf(answer, maxVal - minHeap.peek().value)

        val least = minHeap.poll()

        if(ptr[least.idx] < m - 1){
            val newInfo = PtrInfo(least.idx, classes[least.idx][++ptr[least.idx]])
            minHeap.add(newInfo)
            maxVal = maxOf(newInfo.value, maxVal)
        }
    }

    //출력
    println(answer)
}
