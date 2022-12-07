import java.util.*

data class Info(var dest:Int, var dist:Int, var via:Int):Comparable<Info>{
    override fun compareTo(other: Info): Int = this.dist - other.dist
}
const val INF = 1000000000

fun main(){
    var st = StringTokenizer(readLine()?:"")

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    //그래프 만들기
    val paths = Array(n + 1){ mutableListOf<Info>() }
    for(i in 1..m) {
        st = StringTokenizer(readLine() ?: "")
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val dist = st.nextToken().toInt()

        paths[from].add(Info(to, dist, to))
        paths[to].add(Info(from, dist, from))
    }

    //답안 저장 배열
    val answer = Array(n + 1){ Array(n + 1){i -> Info(i,INF,0)} }

    //다익스트라
    for(i in 1..n) {
        val visited = BooleanArray(n + 1){false}
        val heap = PriorityQueue<Info>()
        heap.add(Info(i, 0, i))

        while (!heap.isEmpty()){
            val cur = heap.poll()

            if(visited[cur.dest]) continue
            visited[cur.dest] = true

            //각 경로 갱신
            paths[cur.dest].forEach{
                //현재 it까지 가는 경로가 cur을 경유하는 것보다 길면
                if(answer[i][it.dest].dist > cur.dist +  it.dist) {
                    answer[i][it.dest].dist = cur.dist + it.dist
                    answer[i][it.dest].via = if(cur.dest == i) it.via else answer[i][cur.dest].via
                    heap.add(Info(it.dest, answer[i][it.dest].dist, cur.dest))
                }
            }
        }
    }

    for(i in 1..n){
        for(j in 1..n){
            if(i == j) print("- ")
            else print("${answer[i][j].via}  ")
        }
        println()
    }
}
