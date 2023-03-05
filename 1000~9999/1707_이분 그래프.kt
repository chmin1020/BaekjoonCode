import java.util.*

const val NOT_DECIDED = 0

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    //테스트 케이스 실행
    val answers = mutableListOf<String>()
    for (i in 0 until tc) {
        //상수 입력
        val (v, e) = br.readLine().split(" ").map { it.toInt() }

        //간선 입력으로 그래프 완성
        val graph = Array(v) { mutableListOf<Int>() }
        for (j in 0 until e) {
            val (n1, n2) = br.readLine().split(" ").map { it.toInt() - 1 }
            graph[n1].add(n2)
            graph[n2].add(n1)
        }

        //연산
        answers.add(if (checkBipartite(graph)) "YES" else "NO")
    }

    //출력
    println(answers.joinToString("\n"))
}

//-- 이분 그래프 확인 함수 --//
fun checkBipartite(graph: Array<MutableList<Int>>): Boolean {
    val vCnt = graph.size
    val included = IntArray(vCnt) { NOT_DECIDED }

    //그래프 탐색
    for (vertex in 0 until vCnt)
        if (included[vertex] == NOT_DECIDED && !bfs(graph, included, vertex))
            return false
    return true
}

//-- bfs 구현 함수 --//
fun bfs(graph: Array<MutableList<Int>>, included: IntArray, start: Int): Boolean {
    val queue: Queue<Int> = LinkedList()

    //시작 설정
    queue.add(start)
    included[start] = 1

    //bfs
    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (node in graph[cur]) {
            //같은 집합에 속하는 케이스 불가
            if (included[node] == included[cur])
                return false

            //인근 노드에는 다른 집합 적용
            if (included[node] == NOT_DECIDED) {
                included[node] = -included[cur]
                queue.add(node)
            }
        }
    }
    return true
}
