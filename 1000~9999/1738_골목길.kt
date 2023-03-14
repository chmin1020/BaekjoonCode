import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val dis: Long)

const val MINUS_INF = Long.MIN_VALUE
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //그래프 세팅
    val edges = mutableListOf<Edge>()
    val distances = LongArray(n) { MINUS_INF }
    val before = IntArray(n) { it }.also { it[0] = -1 }
    val cycleExist = BooleanArray(n)

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt() - 1
        val to = st.nextToken().toInt() - 1
        val dis = st.nextToken().toLong()
        edges.add(Edge(from, to, dis))
    }

    //최적 경로 연산
    bellmanFord(edges, distances, before, cycleExist)

    edges.forEach {
        if(cycleExist[it.from])
            cycleExist[it.to] = true
    }

    //출력
    val answer = extractPath(n, before, cycleExist)
    println(answer?.joinToString(" ") ?: -1)
}

//-- 벨만 포드로 경로 찾기, 사이클 여부 리턴 --//
fun bellmanFord(edges: List<Edge>, distances: LongArray, before: IntArray, cycleExist: BooleanArray) {
    distances[0] = 0
    repeat(distances.size) { step ->
        edges.forEach {
            //더 이득이 큰 경로로 갱신 가능
            if (distances[it.from] != MINUS_INF && distances[it.to] < distances[it.from] + it.dis) {
                distances[it.to] = distances[it.from] + it.dis
                before[it.to] = it.from

                //무한 사이클 존재
                if (step == distances.lastIndex)
                    cycleExist[it.to] = true
            }
        }
    }
}

//-- 경로 찾기 --//
fun extractPath(last: Int, before: IntArray, cycleExist: BooleanArray): List<Int>? {
    var idx = before[last - 1]
    val record = mutableListOf<Int>()

    if (cycleExist[last - 1])
        return null

    record.add(last)
    while (idx != -1) {
        if (cycleExist[idx])
            return null
        record.add(idx + 1)
        idx = before[idx]
    }
    record.reverse()

    return record
}
