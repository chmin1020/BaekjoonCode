import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //순서 정보 입력
    val preCounts = IntArray(n + 1)
    val graph = Array(n + 1){ mutableListOf<Int>() }

    repeat(m){
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        graph[n1].add(n2)
        preCounts[n2]++
    }

    val answers = topologicalSort(preCounts, graph, n)

    //출력
    println(answers.joinToString(" "))
    br.close()
}

//-- 조건에 맞는 위상 정렬 결과를 반환 --//
fun topologicalSort(preCounts: IntArray, graph: Array<MutableList<Int>>, n: Int): List<Int>{
    val res = mutableListOf<Int>()

    val solved = BooleanArray(n + 1) { false }
    val heap = PriorityQueue<Int>()

    //최초 문제 투여
    addProblem(heap, preCounts, solved)

    while(heap.isNotEmpty()){
        //문제 풀이
        val cur = heap.poll()
        res.add(cur)

        //문제 관계 갱신
        graph[cur].forEach {
            preCounts[it]--
        }

        //가능한 문제 heap 투여
        addProblem(heap, preCounts, solved)
    }
    return res
}

//-- 풀 문제를 힙에 추가 --//
fun addProblem(heap: PriorityQueue<Int>, preCounts: IntArray, solved: BooleanArray){
    for(i in 1 until preCounts.size){
        if(preCounts[i] == 0 && !solved[i]) {
            heap.add(i)
            solved[i] = true
        }
    }
}
