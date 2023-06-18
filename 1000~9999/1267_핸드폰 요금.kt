fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    br.readLine()
    val list = br.readLine().split(" ").map { it.toInt() }

    //연산
    val yResult = list.fold(0){tot, it -> tot + getResult(it + 1, 10, 30)}
    val mResult = list.fold(0){tot, it -> tot + getResult(it + 1, 15, 60)}

    //출력
    with(System.out.bufferedWriter()) {
        if(yResult < mResult)
            write("Y $yResult\n")
        else if(yResult > mResult)
            write("M $mResult\n")
        else
            write("Y M $yResult")
        flush()
        close()
    }
}

//-- 영식 요금제 계산 --//
fun getResult(time: Int, default: Int, limit: Int): Int{
    return default * (time / limit) + (if(time % limit == 0) 0 else default)
}
