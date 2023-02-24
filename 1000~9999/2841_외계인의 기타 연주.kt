fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, _) = br.readLine().split(" ").map { it.toInt() }

    //각 줄의 플랫 상태
    val guitarState = Array(7){ mutableListOf<Int>()}

    //하나씩 수행
    var cnt = 0
    repeat(n){
        val (lineNum, flatNum) = br.readLine().split(" ").map { it.toInt() }
        val last = if(guitarState[lineNum].isEmpty()) null else guitarState[lineNum].last()

        //더 높은 손가락 떼기
        while (guitarState[lineNum].isNotEmpty() && guitarState[lineNum].last() > flatNum){
            guitarState[lineNum].removeLast()
            cnt++
        }

        //현재 해당 플랫 줄을 누르고 있지 않으면 누르기
        if(guitarState[lineNum].isEmpty() || guitarState[lineNum].last() != flatNum) {
            guitarState[lineNum].add(flatNum)
            cnt++
        }
    }

    //출력
    println(cnt)
    br.close()
}
