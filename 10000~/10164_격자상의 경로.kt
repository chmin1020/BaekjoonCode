fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n + 1){ IntArray(m + 1){ 0 } }.also { it[0][1] = 1 }

    if(k != 0){
        // 교차지
        val restVal = k % m
        val cx = (k / m) + if(restVal == 0) 0 else 1
        val cy = if(restVal == 0) m else restVal

        getPathCountHereToThere(arr, 1, 1, cx, cy)
        getPathCountHereToThere(arr, cx, cy, n, m)
    }
    else
        getPathCountHereToThere(arr, 1, 1, n, m)

    //출력
    with(System.out.bufferedWriter()){
        write("${arr[n][m]}\n")
        flush()
        close()
    }
}

//-- dp 통한 답 구하기 --//
fun getPathCountHereToThere(arr: Array<IntArray>, sx: Int, sy: Int, ex: Int, ey: Int){
    for(x in sx..ex)
        for(y in sy..ey)
            arr[x][y] = arr[x - 1][y] + arr[x][y - 1] //위 아니면 왼쪽에서 왔음
}
