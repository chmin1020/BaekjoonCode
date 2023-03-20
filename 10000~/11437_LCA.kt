const val INF = 100000000
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //트리 입력
    val notDecided = mutableSetOf<Int>().also { it.addAll(1 .. n) }
    val children = Array(n + 1){ mutableListOf<Int>() }
    val parent = IntArray(n + 1).also{ it[1] = 0 }
    val depth = IntArray(n + 1){ INF }.also { it[0] = 0 }
    repeat(n - 1){
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        children[n1].add(n2)
        children[n2].add(n1)
    }
    dfsForMakingTree(notDecided, children, parent, depth, 1)


    //출력 상수 입력
    val m = br.readLine().toInt()

    //목표 입력
    val answers = mutableListOf<Int>()
    repeat(m){
        val (n1, n2) = br.readLine().split(" ").map { it.toInt() }
        answers.add(lca(parent, depth, n1, n2))
    }

    //출력
    println(answers.joinToString("\n"))
}

//-- tree 완성 dfs --//
fun dfsForMakingTree(notDecided: MutableSet<Int>, children: Array<MutableList<Int>>, parent: IntArray, depth: IntArray, idx: Int){
    if(children[idx].isEmpty())
        return

    depth[idx] = depth[parent[idx]] + 1
    notDecided.remove(idx)
    children[idx].forEach {
        if(notDecided.contains(it)) {
            parent[it] = idx
            dfsForMakingTree(notDecided, children, parent, depth, it)
        }
    }
}

//-- 공통 조상 찾기 알고리즘 --//
fun lca(parent: IntArray, depth: IntArray, n1: Int, n2: Int): Int{
    var t1 = n1
    var t2 = n2

    //깊이 맞추기
    if(depth[t1] > depth[t2])
        t1 = t2.also { t2 = t1 }
    while (depth[t1] < depth[t2])
        t2 = parent[t2]

    //같이 올라가면서 부모 같은지 확인
    while (t1 != t2){
        t1 = parent[t1]
        t2 = parent[t2]
    }

    return t1
}
