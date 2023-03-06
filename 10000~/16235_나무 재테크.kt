import java.util.*

//나무 번식을 위한 방향 정의
const val DIRECT_CNT = 8
val directX = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
val directY = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)

//나무 정보 데이터 클래스
data class TreeInfo(val x: Int, val y: Int, val age: Int): Comparable<TreeInfo>{
    override fun compareTo(other: TreeInfo): Int {
        return this.age - other.age
    }
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    //land 설정
    val land = Array(n){ IntArray(n) {5} }

    //추가 양분 설정
    val addingNutriments = Array(n){ IntArray(n) }
    for(idx in 0 until n)
        addingNutriments[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    //나무 설정
    val trees = PriorityQueue<TreeInfo>()
    repeat(m){
        val (x, y, age) = br.readLine().split(" ").map { it.toInt() }
        trees.add(TreeInfo(x - 1, y - 1, age))
    }

    //k년 보내기 시뮬레이션
    repeat(k){
        doYearSimulation(land, addingNutriments, trees) }

    //출력
    println(trees.size)
}

//-- 1년 치 나무 생활 시뮬레이션 --//
fun doYearSimulation(land: Array<IntArray>, addingNutriments: Array<IntArray>, trees: PriorityQueue<TreeInfo>){
    val surviveTrees = mutableListOf<TreeInfo>()
    val deadTrees = mutableListOf<TreeInfo>()

    //봄, 여름, 가을, 겨울 보내기
    onSpring(land, trees, surviveTrees, deadTrees)
    onSummer(land, deadTrees)
    onFall(trees, surviveTrees, land.indices)
    onWinter(land, addingNutriments)
}

//-- 봄 이벤트 --//
fun onSpring(land: Array<IntArray>, trees: PriorityQueue<TreeInfo>, surviveTrees: MutableList<TreeInfo>, deadTrees: MutableList<TreeInfo>){
    while (trees.isNotEmpty()){
        val cur = trees.poll()

        //양분 있으면 먹고 살고, 없으면 죽음
        if(land[cur.x][cur.y] >= cur.age){
            surviveTrees.add(TreeInfo(cur.x, cur.y, cur.age + 1))
            land[cur.x][cur.y] -= cur.age
        }
        else
            deadTrees.add(cur)
    }
}

//-- 여름 이벤트 --//
fun onSummer(land: Array<IntArray>, deadTrees: MutableList<TreeInfo>){
    deadTrees.forEach {
        land[it.x][it.y] += (it.age / 2)
    }
}

//-- 가을 이벤트 --//
fun onFall(trees: PriorityQueue<TreeInfo>, surviveTrees: MutableList<TreeInfo>, range: IntRange){
    surviveTrees.forEach {
        if(it.age % 5== 0){
            for(d in 0 until DIRECT_CNT){
                val nx = it.x + directX[d]
                val ny = it.y + directY[d]

                //땅 범위 벗어나면 신경 안씀
                if(nx !in range || ny !in range)
                    continue

                trees.add(TreeInfo(nx, ny, 1))
            }
        }
        trees.add(it)
    }
}

//-- 겨울 이벤트 --//
fun onWinter(land: Array<IntArray>, addingNutriments: Array<IntArray>){
    for(i in land.indices)
        for(j in land.indices)
            land[i][j] += addingNutriments[i][j]
}
