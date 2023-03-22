const val NO_PARENT = "@"
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    repeat(tc){
        val f = br.readLine().toInt()
        val parentMap = mutableMapOf<String, String>()
        val cntMap = mutableMapOf<String, Int>()

        for(i in 0 until f){
            val (p1, p2) = br.readLine().split(" ")
            if(parentMap[p1] == null) parentMap[p1] = p1
            if(parentMap[p2] == null) parentMap[p2] = p2
            if(cntMap[p1] == null) cntMap[p1] = 1
            if(cntMap[p2] == null) cntMap[p2] = 1

            union(parentMap, cntMap, p1, p2)

            //개수 세서 출력
            val targetParent = find(parentMap, p1)
            println(cntMap[targetParent] ?: 0)
        }
    }
}

//-- union --//
fun union(parentMap: MutableMap<String, String>, cntMap: MutableMap<String, Int>, person1: String, person2: String){
    val parent1 = find(parentMap, person1)
    val parent2 = find(parentMap, person2)

    if(parent1 != parent2) {
        val newCnt = (cntMap[parent1] ?: 0) + (cntMap[parent2] ?: 0)
        if (parent1 > parent2) {
            parentMap[parent2] = parent1
            cntMap[parent1] = newCnt
        }
        else {
            parentMap[parent1] = parent2
            cntMap[parent2] = newCnt
        }
    }
}

//-- find --//
fun find(parentMap: MutableMap<String, String>, person: String): String{
    val parent = parentMap[person] ?: NO_PARENT
    if(parent == person || parent == NO_PARENT)
        return parent

    return find(parentMap, parent).also { parentMap[person] = it }
}
