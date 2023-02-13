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
    val dp = IntArray(n).also { it[0] = 1 }
    var lastIdx = 0
    for(i in 1 until arr.size){
        //마지막보다 더 크면 새로 추가, 아니면 이진탐색으로 맞는 자리 찾기
        if(searchResult[lastIdx] < arr[i]) {
            searchResult[++lastIdx] = arr[i]
            dp[i] = lastIdx + 1
        }
        else
            dp[i] = binaryBatch(lastIdx, arr[i], searchResult)
    }

    //println(dp.joinToString(" "))

    //역추적을 통한 계산
    val stack = Stack<Int>()
    var target = lastIdx + 1
    for(i in n-1 downTo 0){
        if(target == dp[i]){
            stack.push(arr[i])
            target--
        }
    }

    //출력
    println(lastIdx + 1)
    while (stack.isNotEmpty())
        print("${stack.pop()} ")
    println()
    br.close()
}

//-- 이진탐색으로 자리를 끼워넣는 함수 --//
fun binaryBatch(last: Int, target: Int, searchResult: IntArray): Int{
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
    return end + 1
}
