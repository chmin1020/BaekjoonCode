import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (_, n) = br.readLine().split(" ").map { it.toInt() }

    //소수 입력
    val primes = br.readLine().split(" ").map { it.toInt() }

    //우선순위 큐를 통한 n번째 구하기
    val heap = PriorityQueue<Long>()
    val checkSet = mutableSetOf<Long>()
    var max = 1L
    heap.add(1)
    checkSet.add(1)
    for (i in 0 until n) {
        val cur = heap.poll()

        //해당 수에 소수들 곱하기
        for (prime in primes) {
            val num = prime * cur

            //체크 필요가 없는 수는 넣지도 않는다
            if (heap.size >= n && max < num)
                continue

            //중복되지 않은 값만 처리
            if (!checkSet.contains(num)) {
                max = maxOf(max, num)
                checkSet.add(num)
                heap.add(num)
            }
        }
    }

    //출력
    println(heap.poll())
    br.close()
}
