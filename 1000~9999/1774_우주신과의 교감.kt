import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

//작은 길이 순으로 정렬될 Edge
data class Edge(val n1: Int, val n2: Int, val distance: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return when {
            this.distance > other.distance -> 1
            this.distance < other.distance -> -1
            else -> 0
        }
    }
}

//좌표 데이터
data class Pos(val x: Long = 0, val y: Long = 0)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val edges = PriorityQueue<Edge>()
    val gods = Array(n) { Pos() }
    val parents = IntArray(n) { it }
    var rest = n - 1

    //우주신들 입력
    for(idx in 0 until n){
        val (x, y) = br.readLine().split(" ").map { it.toLong() }
        gods[idx] = Pos(x, y)
    }

    //이미 연결된 신들 활성화
    repeat(m){
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() - 1 }
        if(union(parents, n1, n2)) rest-- //연결하기
    }

    //모든 edge 추가
    for (i in gods.indices)
        for (j in i + 1 until gods.size)
            edges.add(Edge(i, j, getDistance(gods[i], gods[j])))

    //크루스칼
    val answer = kruskal(parents, edges, rest)

    //출력
    println(String.format("%.2f", answer))
    br.close()
}

//-- edge 거리 구하기 함수 --//
fun getDistance(pos1: Pos, pos2: Pos) =
    sqrt((pos1.x - pos2.x).toDouble().pow(2) + (pos1.y - pos2.y).toDouble().pow(2))

//-- 크루스칼 알고리즘 함수 --//
fun kruskal(parents: IntArray, edges: PriorityQueue<Edge>, rest: Int): Double {
    var result = 0.0
    var cnt = rest

    while (cnt > 0 && edges.isNotEmpty()) {
        val cur = edges.poll()

        //-1로 합쳐진 유니온 있었음
        if (union(parents, cur.n1, cur.n2)) {
            cnt-- //m개를 다 -1로 연결시키면 종료
            result += cur.distance
        }
    }
    return result
}

//-- 유니온 --//
fun union(parents: IntArray, n1: Int, n2: Int): Boolean {
    val parent1 = find(parents, n1)
    val parent2 = find(parents, n2)

    if (parent1 == parent2)
        return false

    if (parent1 < parent2)
        parents[parent2] = parent1
    else if (parent1 > parent2)
        parents[parent1] = parent2

    return true
}


//-- 파인드 --//
fun find(parents: IntArray, target: Int): Int {
    if (target == -1 || parents[target] == target)
        return target

    parents[target] = find(parents, parents[target])
    return parents[target]
}
