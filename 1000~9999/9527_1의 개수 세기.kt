val bitDp = LongArray(60).also { it[0] = 1 }

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (start,end) = br.readLine().split(" ").map { it.toLong() }

    //누적합으로 최대 비트 당 1 개수 채우기
    for (i in 1 until 60)
        bitDp[i] = bitDp[i - 1] * 2 + ((1L).shl(i))

    val answer = getOneCnt(end) - getOneCnt(start - 1)

    //출력
    println(answer)
    br.close()
}

//-- 1 ~ num 범위 1의 개수 세기 함수 --//
fun getOneCnt(num: Long): Long{
    var ans = num.and(1)
    var curValue = num

    for(i in 60 downTo 1){
        //최대 비트가 될 수 없으면 넘어감
        val comp = (1L).shl(i)
        if(curValue.and(comp) == 0L)
            continue

        //최대 비트 수 미만의 1 개수 + 그 이후로 나타난 최대 비트의 1 개수
        ans += (bitDp[i - 1] + (curValue - comp + 1))

        //세부 아래 수로 들어가기
        curValue -= comp
    }
    return ans
}
