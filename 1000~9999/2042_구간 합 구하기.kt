class SegmentTree(private val targetArr: LongArray){
    private val tree = LongArray(4 * targetArr.size)

    init { treeSetting(1, targetArr.size - 1, 1) }

    //최초 세팅
    private fun treeSetting(start: Int, end: Int, node: Int): Long{
        if(start == end)
            tree[node] = targetArr[start]
        else {
            val mid = (start + end) / 2
            tree[node] = treeSetting(start, mid, node * 2) + treeSetting(mid + 1, end, node * 2 + 1)
        }

        return tree[node]
    }

    //구간 합 구하기
    fun getSum(start: Int, end: Int, node: Int, left: Int, right: Int): Long{
        if(left > end || right < start) return 0
        if(left <= start && end <= right) return tree[node]

        val mid = (start + end) / 2
        return getSum(start, mid, node * 2, left, right) + getSum(mid + 1, end, node * 2 + 1, left, right)
    }

    // 배열 값 업데이트
    fun update(start: Int, end: Int, node: Int, idx: Int, dif: Long){
        if(idx < start || idx > end) return
        tree[node] += dif

        if(start == end) return

        val mid = (start + end) / 2
        update(start, mid, node * 2, idx, dif)
        update(mid + 1, end, node * 2 + 1, idx, dif)
    }
}

fun main() {
    //입력
    val (n, m, k) = (readLine() ?: "0 0 0").split(" ").map { it.toInt() }

    val numArr= LongArray(n + 1)
    for(i in 1 .. n)
        numArr[i] = (readLine() ?: "0").toLong()

    val tree = SegmentTree(numArr)

    for(i in 0 until m + k){
        val (order, param1, c) = (readLine() ?: "0 0 0").split(" ").map { it.toLong() }
        val b = param1.toInt()

        if(order == 1L) // 변경
            tree.update(1, n, 1, b, (c - numArr[b])).also { numArr[b] = c }
        else //출력
            println(tree.getSum(1, n, 1, b, c.toInt()))
    }
}
