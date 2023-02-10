import java.util.*

data class Planet(val idx: Int, val value: Int): Comparable<Planet>{
    override fun compareTo(other: Planet) = this.value - other.value
}
data class Edge(val idx1: Int, val idx2: Int, val cost: Int): Comparable<Edge> {
    override fun compareTo(other: Edge) = this.cost - other.cost
}

private lateinit var group: IntArray

fun main(){
    //입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    //위치값들 받아서 저장
    val planetWithX = mutableListOf<Planet>()
    val planetWithY = mutableListOf<Planet>()
    val planetWithZ = mutableListOf<Planet>()
    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        planetWithX.add(Planet(i, st.nextToken().toInt()))
        planetWithY.add(Planet(i, st.nextToken().toInt()))
        planetWithZ.add(Planet(i, st.nextToken().toInt()))
    }
    group = IntArray(n) { it }

    //x, y, z 정렬
    planetWithX.sort()
    planetWithY.sort()
    planetWithZ.sort()

    //최종 edge 모으기
    val edges = mutableListOf<Edge>()
    for(i in 0 until n - 1){
        edges.add(Edge(planetWithX[i + 1].idx, planetWithX[i].idx, planetWithX[i + 1].value - planetWithX[i].value))
        edges.add(Edge(planetWithY[i + 1].idx, planetWithY[i].idx, planetWithY[i + 1].value - planetWithY[i].value))
        edges.add(Edge(planetWithZ[i + 1].idx, planetWithZ[i].idx, planetWithZ[i + 1].value - planetWithZ[i].value))
    }
    edges.sort()

    //합쳐지는 경우 합계에 더하기
    var total = 0
    for(i in edges.indices) {
        val (idx1, idx2, cost) = edges[i]

        val group1 = find(idx1)
        val group2 = find(idx2)

        if(group1 != group2){
            if(group1 < group2) group[group2] = group1
            else group[group1] = group2
            total += cost
        }
    }

    //연산 후 출력
    println(total)

    br.close()
}

//-- find 함수 --//
fun find(idx: Int): Int{
    return if(group[idx] == idx) {
        return idx
    }
    else{
        //그룹 갱신
        group[idx] = find(group[idx])
        group[idx]
    }
}
