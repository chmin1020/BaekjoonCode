fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    br.readLine()
    val seq = br.readLine().split(" ").map { it.toInt() }

    //답 구하기
    val answer = getAnswer(seq)

    //출력
    with(System.out.bufferedWriter()){
        write("$answer\n")
        flush()
        close()
    }
}

//-- 답 구하기 --//
fun getAnswer(seq: List<Int>): Int{
    val arr = IntArray(seq.size).also { it[0] = seq.first() }
    var ptr = 1

    seq.forEach{
        if(it > arr[ptr - 1]) //마지막 값보다 큼
            arr[ptr++] = it
        else { //중간에 들어가야 함
            val idx = binarySearch(arr, 0, ptr, it)
            arr[idx] = it
        }
    }
    return ptr
}

//-- 위치 찾기 이분 탐색 --//
fun binarySearch(arr: IntArray, start: Int, end: Int, value: Int): Int{
    var left = start
    var right = end

    //lower bound
    while(left < right){
        val mid = (left + right) / 2

        if(arr[mid] < value)
            left = mid + 1
        else
            right = mid
    }

    return right
}
