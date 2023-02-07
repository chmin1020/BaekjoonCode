fun main(){
    //입력
    val (n, k) = (readLine()?:"").split(" ").map { it.toInt() }
    val arr = ("0 " + readLine()).split(" ").map { it.toLong() }.toLongArray()

    val possiblePairs = mutableMapOf<Long, Long>()

    //1~ 누적합 배열로 만들기, 각 값들을 맵에 저장
    var answer = 0L
    for(i in 1 .. n) {
        arr[i] += arr[i - 1]

        //k 가능한 경우 더하기
        if(arr[i] == k.toLong()) answer++
        answer += (possiblePairs[arr[i] - k.toLong()] ?: 0L)

        //맵에 추가
        possiblePairs[arr[i]] = (possiblePairs[arr[i]] ?: 0L) + 1L
    }

    //출력
    println(answer)
}
