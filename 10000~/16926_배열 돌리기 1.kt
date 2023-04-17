fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(m) }
    repeat(n) { idx ->
        arr[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    //각 테두리 회전 횟수 정하기
    val rotateNumbers = mutableListOf<Int>()
    for (pivot in 0 until minOf(m, n) / 2) {
        val height = n - pivot * 2
        val width = m - pivot * 2
        rotateNumbers.add(r % (2 * (height + width) - 4))
    }

    //각자 회전
    var pivot = 0
    rotateNumbers.forEach {
        for(i in 0 until it)
            rotateArr(n, m, pivot, arr)
        pivot++
    }

    //출력
    with(System.out.bufferedWriter()) {
        for (i in arr.indices)
            write("${arr[i].joinToString(" ")}\n")
        flush()
        close()
    }
}

//-- 숫자 회문 여부 판별 --//
fun rotateArr(n: Int, m: Int, pivot: Int, arr: Array<IntArray>) {
    var tmp = arr[pivot][pivot]

    //아래로
    for(i in pivot + 1 until n - pivot)
        arr[i][pivot] = tmp.also { tmp = arr[i][pivot] }

    //우측으로
    for(i in pivot + 1 until m - pivot)
        arr[n - pivot - 1][i] = tmp.also { tmp = arr[n - pivot -1][i] }

    //위로
    for(i in n - pivot - 2 downTo pivot)
        arr[i][m - pivot - 1] = tmp.also { tmp = arr[i][m - pivot - 1] }

    //좌측으로
    for(i in m - pivot - 2 downTo pivot)
        arr[pivot][i] = tmp.also { tmp = arr[pivot][i] }
}
