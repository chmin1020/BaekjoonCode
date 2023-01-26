import java.util.*

class Info(val idx: Int, val value: Int): Comparable<Info>{
    override fun compareTo(other: Info) = other.value - this.value
}

fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()

    val arr = Array(n){IntArray(n)}
    val pointers = IntArray(n){n - 1}
    for(i in 0 until n)
        arr[i] = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //맨 위 힙에 저장
    val heap = PriorityQueue<Info>()
    heap.addAll(arr[n - 1].mapIndexed { idx, it -> Info(idx, it) })

    //값 빼고 더하기 반복
    for(i in 1 until n) {
        val curIdx = heap.peek().idx
        val new = Info(curIdx, arr[--pointers[curIdx]][curIdx])

        heap.poll()
        heap.add(new)
    }

    //출력
    println(heap.peek().value)
}
