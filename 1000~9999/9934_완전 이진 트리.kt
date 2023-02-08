val nodeMap = mutableMapOf<Int, MutableList<Int>>()

fun main(){
    //입력
    val k = (readLine() ?: "").toInt()
    val treeInOrder = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //트리 맵 채우기
    for(depth in 1 .. k)
        nodeMap[depth] = mutableListOf()

    //분석
    treeAnalysis(treeInOrder, 0, treeInOrder.lastIndex, 1, k)

    //출력
    for(depth in 1 .. k)
        println(nodeMap[depth]?.joinToString(" "))
}

//-- 재귀를 통한 트리 루트 분석 함수 --//
fun treeAnalysis(treeInfo: IntArray, start: Int, end: Int, curDepth: Int, limitDepth: Int){
    //높이 끝까지 갔으면 종료
    if(curDepth > limitDepth)
        return

    //가운데가 루트
    val mid = (start + end) / 2
    nodeMap[curDepth]?.add(treeInfo[mid])

    //좌우 서브트리 분석
    treeAnalysis(treeInfo, start, mid, curDepth + 1, limitDepth)
    treeAnalysis(treeInfo, mid + 1, end, curDepth + 1, limitDepth)
}
