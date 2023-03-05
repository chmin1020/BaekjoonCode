const val NOT_EXIST = -1

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (h,w) = br.readLine().split(" ").map { it.toInt() }

    //부등호 입력
    val blockHeights = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    //시뮬레이션
    var answer = 0
    val current = IntArray(h){NOT_EXIST}

    for((idx, height) in blockHeights.withIndex()){
        for(each in 0 until height){
            if(current[each] != NOT_EXIST)
                answer += (idx - current[each] - 1)
            current[each] = idx
        }
    }

    //출력
    println(answer)
}
