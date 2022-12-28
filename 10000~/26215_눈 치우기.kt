import java.util.*

fun main() {
    //입력 받아 역순으로 정렬
    readLine() // n 무시
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    heap.addAll((readLine() ?: "").split(" ").map { it.toInt() })

    var answer = 0

    if(heap.size == 1) // 사이즈가 1이면 집 하나만 고려
        answer = heap.poll()
    else{
        //눈이 많은 집 2개를 골라 1씩 처리
        while (heap.size > 1) {
            var many = heap.poll()
            var little = heap.poll()
            if(--many > 0) heap.add(many)
            if(--little > 0) heap.add(little)
            
            answer++
        }
        //마지막 남은 눈 처리
        if(heap.isNotEmpty()) answer += heap.poll()
    }

    if(answer > 1440)
        answer = -1
    println(answer)
}
