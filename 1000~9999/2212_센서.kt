import java.util.*

fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()
    val k = (readLine() ?: "0").toInt()
    val poses = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //각 좌표 사이 거리를 큰 수부터 저장하는 heap
    poses.sort()
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    for(i in 0..poses.size - 2)
        heap.add(poses[i + 1] - poses[i])

    // n - k개 남을 때까지 큰 수 제외
    for(i in 1 until k)
        heap.poll()

    //답 구하기
    var answer = 0
    while (heap.isNotEmpty())
        answer += heap.poll()

    //출력
    println(answer)
}
