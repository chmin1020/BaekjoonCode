const val INF = 50000000
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1){ IntArray(n + 1){ INF } }

    repeat(k){
        val (prev, next) = br.readLine().split(" ").map { it.toInt() }
        graph[prev][next] = 1
    }

    settingOrders(graph)

    //출력
    with(System.out.bufferedWriter()) {
        repeat(br.readLine().toInt()){
            val (prev, next) = br.readLine().split(" ").map { it.toInt() }
            if(graph[prev][next] == INF && graph[next][prev] == INF)
                write("0\n")
            else if(graph[prev][next] != INF)
                write("-1\n")
            else
                write("1\n")
        }
        flush()
        close()
    }
}

//-- 세팅 --//
fun settingOrders(graph: Array<IntArray>){
    //플로이드 와샬
    for(k in graph.indices){
        for(i in graph.indices){
            for(j in graph.indices){
                if(graph[i][j] > graph[i][k] + graph[k][j])
                    graph[i][j] = graph[i][k] + graph[k][j]
            }
        }
    }
}

