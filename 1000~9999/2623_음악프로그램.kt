fun main(){
    //입력
    val (n, m) = (readLine() ?: "").split(" ").map { it.toInt() }

    //답 저장 리스트
    val answers = mutableListOf<Int>()

    //그래프 채우기
    val alreadyDecided = BooleanArray(n + 1){false}
    val inGraph = Array(n + 1){ mutableSetOf<Int>() } //자기한테 들어오는거
    val outGraph = Array(n + 1){ mutableSetOf<Int>() } //자기가 나가는거
    for(i in 0 until m){
        val inputs = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()
        for(idx in 2 until inputs.size) {
            inGraph[inputs[idx]].add(inputs[idx - 1])
            outGraph[inputs[idx - 1]].add(inputs[idx])
        }
    }

    //위상 정렬
    var doNext = true
    while(doNext){
        doNext = false

        for(singerIdx in n downTo 1){
            //자기 앞에 누군가 있어야 하는 제약조건이 없으며 아직 배치되지 않은 가수
            if(!alreadyDecided[singerIdx] && inGraph[singerIdx].isEmpty()){
                //배치
                answers.add(singerIdx)
                alreadyDecided[singerIdx] = true

                //다른 가수들 제약 조건에서 현재 가수 제거
                outGraph[singerIdx].forEach {
                    inGraph[it].remove(singerIdx)
                }

                //다음 진행 가능
                doNext = true
            }
        }
    }

    //출력
    if(inGraph.any{ it.isNotEmpty() })
        println(0)
    else
        println(answers.joinToString("\n"))
}
