fun main() {
    val answers = mutableListOf<Int>()

    val tc = (readLine() ?: "0").toInt()

    //각 테스트 케이스 실행
    for(eachTestCase in 0 until tc){
        //입력 및 저장
        val num = (readLine() ?: "0").toInt()
        val results = mutableListOf<Pair<Int, Int>>()
        for(i in 0 until num){
            val (first, second) = (readLine() ?: "").split(" ").map { it.toInt() }
            results.add(Pair(first, second))
        }

        //정렬 후 결과 확인
        val checkArr = results.toTypedArray()
        checkArr.sortBy { it.first }

        var cnt = 1
        var highRankSoFar = checkArr[0].second
        for(i in 1 until checkArr.size){
            if(highRankSoFar > checkArr[i].second) {
                highRankSoFar = checkArr[i].second
                cnt++
            }
        }

        answers.add(cnt)
    }

    //출력
    println(answers.joinToString("\n"))
}
