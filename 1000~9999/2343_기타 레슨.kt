fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (_, m) = br.readLine().split(" ").map { it.toInt() }

    //각 강의
    val records = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val totalTime = records.sum()
    val maxLength = records.maxByOrNull { it } ?: records[0]

    //연산 및 출력
    println(binarySearch(records, maxLength, totalTime, m))
    br.close()
}

//-- 파라메트릭 서치를 통한 답 연산 수행 --//
fun binarySearch(records: IntArray, min: Int, max: Int, m: Int): Int{
    var start = min
    var end = max

    var res = max
    while (start <= end){
        val length = (start + end) / 2
        val neededCnt = getNeededBlueLayCount(records, length)

        if(neededCnt > m)
            start = length + 1
        else {
            res = minOf(res, length)
            end = length - 1
        }
    }
    return res
}

//-- 블루레이가 몇 개 필요한지 계산하는 함수 --//
fun getNeededBlueLayCount(records: IntArray, length: Int): Int{
    var cnt = 1
    var curLength = 0

    for(each in records){
        if(curLength + each > length){
            cnt++
            curLength = 0
        }
        curLength += each
    }
    return cnt
}
