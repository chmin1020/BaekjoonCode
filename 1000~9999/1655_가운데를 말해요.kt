import java.util.*

fun main(){
    //입력
    val n = (readLine()?:"").toInt()

    //필요 컬렉션 준비
    val answers = mutableListOf<Int>()
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    val minHeap = PriorityQueue<Int>()

    for(i in 0 until n){
        val num = (readLine()?:"").toInt()

        //중간값은 maxHeap top, 기본적으로 작은걸 maxHeap 삽입
        if(minHeap.size < maxHeap.size){ //현재 홀수개
            if(maxHeap.peek() > num){
                minHeap.add(maxHeap.poll())
                maxHeap.add(num)
            }
            else
                minHeap.add(num)
        }
        else { //현재 짝수개
            if(minHeap.isNotEmpty() && minHeap.peek() < num){
                maxHeap.add(minHeap.poll())
                minHeap.add(num)
            }
            else
                maxHeap.add(num)
        }

        //중간값 뽑아내기
        answers.add(maxHeap.peek())
    }

    //출력
    println(answers.joinToString("\n"))
}
