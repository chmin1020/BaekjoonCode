data class CountingInfo(val value: Int, var count: Int)

fun main(){
    //입력
    val n = (readLine()?:"").toInt()

    val arr = Array(n){CountingInfo(0,0)}
    for(i in 0 until n) {
        arr[i] = CountingInfo((readLine() ?: "").toInt(), 0)
    }

    //최대 inverse count 세기
    calculateMaxInverseCount(n, arr)

    //출력
    println(1 + (arr.maxByOrNull { it.count }?.count ?: 0))
}

//-- 카운팅을 시작하는 함수 --//
fun calculateMaxInverseCount(n: Int, arr: Array<CountingInfo>){
    val newArr = Array(n){CountingInfo(0,0)}
    mergeSortJob(0, arr.lastIndex, arr, newArr)
}

//-- 병합 정렬을 하면서 자연스럽게 카운팅까지하는 함수 --//
fun mergeSortJob(start: Int, end: Int, arr: Array<CountingInfo>, newArr: Array<CountingInfo>){
    if(start == end)
        return

    //나누기
    val mid = (start + end) / 2
    mergeSortJob(start, mid, arr, newArr)
    mergeSortJob(mid + 1, end, arr, newArr)

    //임시 배열에 정렬하여 옮겨 담기
    var frontIdx = start
    var backIdx = mid + 1
    var newIdx = start
    while(frontIdx <= mid && backIdx <= end){
        if(arr[frontIdx].value > arr[backIdx].value) {
            arr[backIdx].count += (mid - frontIdx + 1)
            newArr[newIdx++] = arr[backIdx++]
        }
        else
            newArr[newIdx++] = arr[frontIdx++]
    }
    while (frontIdx <= mid) newArr[newIdx++] = arr[frontIdx++]
    while (backIdx <= end) newArr[newIdx++] = arr[backIdx++]

    //원래 배열에 복구
    for(idx in start..end)
        arr[idx] = newArr[idx]
}
