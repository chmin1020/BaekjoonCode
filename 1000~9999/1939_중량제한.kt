import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Bridge(val dest: Int, val len: Int)

fun main(){
    //입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    //그래프
    val graph = Array(n + 1){ mutableListOf<Bridge>()}

    for(i in 0 until m){
        st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        graph[a].add(Bridge(b, c))
        graph[b].add(Bridge(a, c))
    }

    //시작지 목적지
    st = StringTokenizer(br.readLine())
    val land1 = st.nextToken().toInt()
    val land2 = st.nextToken().toInt()


    //이진탐색으로 최적의 무게 찾아서 출력
    println(weightSearch(graph, n, land1, land2))
}

//-- 이진탐색을 통한 최적의 무게 찾기 함수 --//
fun weightSearch(graph: Array<MutableList<Bridge>>, n: Int, start: Int, end: Int): Int{
    var low = 1
    var high = 1000000000

    var best = 0
    while(low <= high){
        val mid = (low + high) / 2

        //가능하면 무게를 더 높여보기, 아니며 낮춰보기
        if(tryTransfer(graph, n, start, end, mid)) {
            low = mid + 1
            best = mid
        }
        else
            high = mid - 1
    }
    return best
}

//-- 해당 무게로 이동이 가능한지 확인하는 함수 --//
fun tryTransfer(graph: Array<MutableList<Bridge>>, n: Int, start: Int, dest: Int, weight: Int): Boolean{
    val visited = BooleanArray(n + 1){false}

    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    //bfs 통한 시뮬레이션
    while (queue.isNotEmpty()){
        val cur = queue.poll()

        //이동이 가능하다
        if(cur == dest)
            return true

        graph[cur].forEach {
            //방문하지 않았고 무게가 이동할 수 있는 곳만
            if(!visited[it.dest] && it.len >= weight){
                queue.add(it.dest)
                visited[it.dest] = true
            }
        }
    }
    return false
}
