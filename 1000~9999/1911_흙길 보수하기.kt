import java.util.PriorityQueue

data class Hole(val start: Int, val end: Int): Comparable<Hole> {
    override fun compareTo(other: Hole) = this.start - other.start
}

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val (cnt, len) = br.readLine().split(" ").map { it.toInt() }

    val heap = PriorityQueue<Hole>()
    repeat(cnt){
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        heap.add(Hole(start, end))
    }

    var answer = 0
    var last:Long = 0
    while(heap.isNotEmpty()){
        val cur = heap.poll()

        if(last < cur.start)
            last = cur.start.toLong()

        while(last < cur.end){
            last += len
            answer++
        }
    }

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer")
        flush()
        close()
    }
}
