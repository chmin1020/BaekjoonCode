fun main(){
    //입력
    val (n, c) = (readLine() ?: "0 0").split(" ").map { it.toInt() }
    val arr = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //반으로 나눠서 각 합 경우의 수들 구하기
    val leftSums = getAllSums(arr, 0, n / 2)
    val rightSums = getAllSums(arr, n / 2 + 1, n - 1)

   //정답 저장 변수
    var answer = 0

    //양 배열의 조합으로 가능한 최종 경우의 수 구하기
    for(leftSum in leftSums){
        //이미 더 넣을 수 없으면 생략
        if(leftSum > c.toLong())
            continue

        //이분 탐색
        answer += getPossibleCnt(rightSums, c.toLong() - leftSum)
    }

    //출력
    println(answer)
}

//-- 배열에서 가능한 모든 조합의 덧셈들 구하는 함수 --//
fun getAllSums(arr: IntArray, start: Int, end: Int): LongArray{
    val sums = mutableListOf<Long>()

    dfs(sums, arr, 0L, start, end)
    sums.sort()
    return sums.toLongArray()
}

//-- 가능한 덧셈 조합을 재귀로 찾는 dfs 함수 --//
fun dfs(sums: MutableList<Long>, arr: IntArray, curSum: Long, ptr: Int, limit: Int){
    //끝까지 갔을 경우 리스트에 저장하고 종료
    if(limit < ptr){
        sums.add(curSum)
        return
    }

    //이번 수를 더하는 경우와 안 더하는 경우
    dfs(sums, arr, curSum, ptr + 1, limit)
    dfs(sums, arr, curSum + arr[ptr], ptr + 1, limit)
}

//-- 가방에 담는게 가능한 경우 개수 구하는 함수 --//
fun getPossibleCnt(arr: LongArray, target: Long): Int{
    //모든 경우가 다 가능하면 바로 전체 개수 리턴
    if(arr.last() <= target)
        return arr.size

    //upper 구하기
    var start = 0
    var end = arr.lastIndex

    while (start < end){
        val mid = (start + end) / 2

        if(arr[mid] <= target) start = mid + 1
        else end = mid
    }

    return start
}
