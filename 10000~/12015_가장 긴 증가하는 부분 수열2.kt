import java.util.*

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    //배열 완성
    val arr = IntArray(n)
    val st = StringTokenizer(br.readLine())
    for(i in arr.indices)
        arr[i] = st.nextToken().toInt()

    val searchResult = IntArray(n).also { it[0] = arr[0] }
    var lastIdx = 0
    for(i in 1 until arr.size){
        //마지막보다 더 크면 새로 추가, 아니면 이진탐색으로 맞는 자리 찾기
        if(searchResult[lastIdx] < arr[i])
            searchResult[++lastIdx] = arr[i]
        else
            binaryBatch(lastIdx, arr[i], searchResult)
    }

    println(searchResult.joinToString(" "))

    //출력
    println(lastIdx + 1)
    br.close()
}

//-- 이진탐색으로 자리를 끼워넣는 함수 --//
fun binaryBatch(last: Int, target: Int, searchResult: IntArray){
    var start = 0
    var end = last

    //이진탐색(lower bound)
    while (start < end){
        val mid = (start + end) / 2

        if(searchResult[mid] >= target)
            end = mid
        else
            start = mid + 1
    }

    //끼워넣기(대체)
    searchResult[end] = target
}
