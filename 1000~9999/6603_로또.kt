
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    while(true){
        val input = br.readLine().split(" ").map{ it.toInt() }
        val numbers = input.subList(1, input.size).toIntArray()
        numbers.sort()

        //0이면 종료
        if(input.first() == 0)
            break

        //답 생성을 위한 dfs
        dfs(numbers, 0, mutableListOf())
        println()
    }

    br.close()
}

//-- dfs 통한 조합 및 순열 --//
fun dfs(numbers: IntArray, curIdx: Int, numList: MutableList<Int>){
    //6개 숫자 뽑히면 답에 추가
    if(numList.size == 6){
        println(numList.joinToString(" "))
        return
    }

    //순서대로 추가
    for(i in curIdx until numbers.size){
        numList.add(numbers[i])
        dfs(numbers, i + 1, numList)
        numList.removeLast()
    }
}
