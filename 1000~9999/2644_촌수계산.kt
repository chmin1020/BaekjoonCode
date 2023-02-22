import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //그래프 생성
    val n = br.readLine().toInt()
    val graph = Array(n){ mutableListOf<Int>()}

    //출발지, 도착지
    val (start, end) = br.readLine().split(" ").map { it.toInt() - 1 }

    //그래프 초기화
    val m = br.readLine().toInt()
    repeat(m){
        val st = StringTokenizer(br.readLine())
        val n1 = st.nextToken().toInt() - 1
        val n2 = st.nextToken().toInt() - 1

        graph[n1].add(n2)
        graph[n2].add(n1)
    }

    //bfs 설정
    var answer = -1
    val visited = BooleanArray(n){false}
    val queue:Queue<Pair<Int, Int>> = LinkedList()

    //bfs 수행
    queue.add(Pair(start, 0))
    visited[start] = true
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        if(cur.first == end){
            answer = cur.second
            break
        }

        //가능한 곳 모두 가보기
        graph[cur.first].forEach {
            if(!visited[it]){
                queue.add(Pair(it, cur.second + 1))
                visited[it] = true
            }
        }
    }

    //출력
    println(answer)
    br.close()
}
