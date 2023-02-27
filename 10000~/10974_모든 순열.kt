fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //탐색 및 출력
    val usedBit = 0
    dfs(0, n, usedBit, mutableListOf<Int>())
    br.close()
}

//-- dfs 통한 탐색 및 출력 --//
fun dfs(cur: Int, lim: Int, usedBit: Int, list: MutableList<Int>){
    //길이만큼 출력했으면 끝
    if(cur == lim){
        println(list.joinToString(" "))
        return
    }

    var checkBit = 1
    for(num in 1 .. lim){
        //안쓴 것 출력
        if(usedBit.and(checkBit) == 0){
            list.add(num)
            dfs(cur + 1, lim, usedBit.or(checkBit), list)
            list.removeLast()
        }
        checkBit = checkBit.shl(1)
    }
}
