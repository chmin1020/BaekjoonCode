import java.util.PriorityQueue

fun main(){
    //입력
    val n = (readLine()?:"").toInt()

    //힙에 작은 순으로 삽입
    val heap = PriorityQueue<Long>()
    for(i in 0 until n)
        heap.add((readLine()?:"").toLong())

    //작은 것부터 더하기
    var answer = 0L
    if(n > 1) {
        while (heap.isNotEmpty()) {
            if(heap.size == 1){ //카드 묶음이 하나 남았다면 합치기 끝
                break
            }
            else { //아니면 두 개 합친 것을 힙에 새로 추가, 답 갱신
                val cur = heap.poll() + heap.poll()
                answer += cur
                heap.add(cur)
            }
        }
    }

    //출력
    println(answer)
}
