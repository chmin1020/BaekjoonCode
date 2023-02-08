import java.util.*

//edge 데이터 클래스
data class Edge(val n1: Int, val n2: Int, val cost: Int): Comparable<Edge>{
    override fun compareTo(other: Edge): Int{
        return this.cost - other.cost
    }
}

val edges = PriorityQueue<Edge>()
fun main(){
    //입력
    val n = (readLine()?:"").toInt()
    val m = (readLine()?:"").toInt()

    for(i in 0 until m){
        val (com1, com2, cost) = (readLine()?:"").split(" ").map { it.toInt() }
        edges.add(Edge(com1, com2, cost))
    }

    //부모 초기 설정
    val parent = IntArray(n + 1)
    parent.forEachIndexed { idx, _ -> parent[idx] = idx }

    //계산 및 출력
    println(kruskal(parent, n))
}

//-- Union 함수 --//
fun union(parent: IntArray, n1: Int, n2: Int): Boolean{
    val parent1 = find(parent, n1)
    val parent2 = find(parent, n2)

    //인덱스가 작은 것을 최종 부모로
    if(parent1 != parent2) {
        if(parent1 < parent2) parent[parent2] = parent1
        else parent[parent1] = parent2
        return true
    }
    return false
}

//-- Find 함수 --//
fun find(parent: IntArray, node: Int): Int{
    if(parent[node] == node)
        return node

    parent[node] = find(parent, parent[node])
    return parent[node]
}

//-- Kruskal 함수 --//
fun kruskal(parent: IntArray, n: Int): Int{
    var cnt = 0
    var length = 0

    //연결 edge == n - 1 까지
    while (edges.isNotEmpty() && cnt < n - 1){
        val cur = edges.poll()

        //새로운 두 노드 결합 발생 (edge 하나 생김)
        if(union(parent, cur.n1, cur.n2)) {
            cnt++
            length += cur.cost
        }
    }
    return length
}
