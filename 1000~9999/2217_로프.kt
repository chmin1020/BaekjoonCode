fun main(){
    //입력
    val n = (readLine()?:"").toInt()
    val arr = IntArray(n)
    for(i in arr.indices)
        arr[i] = (readLine()?:"").toInt()

    //계산
    var answer = 0
    var cnt = 1
    arr.sortedBy { -it }.forEach {
        answer = maxOf(answer, it * cnt)
        cnt++
    }

    //출력
    println(answer)
}

