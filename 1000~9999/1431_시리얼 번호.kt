import java.util.PriorityQueue

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()

    //짧은 순 -> 숫자 합 순 -> 사전 순 비교 heap
    val heap = PriorityQueue<String>(Comparator { o1, o2 ->
        if(o1.length == o2.length){
            val o1Sum = o1.filter { it.isDigit() }.map { it - '0' }.sumOf { it }
            val o2Sum = o2.filter { it.isDigit() }.map { it - '0' }.sumOf { it }

            if(o1Sum == o2Sum)
                o1.compareTo(o2)
            else
                o1Sum - o2Sum
        }
        else
            o1.length - o2.length
    })

    repeat(cnt){ heap.add(br.readLine()) }

    //출력
    with(System.out.bufferedWriter()) {
        while (heap.isNotEmpty())
            write("${heap.poll()}\n")
        flush()
        close()
    }
}
