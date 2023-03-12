fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, s) = br.readLine().split(" ").map { it.toInt() }

    //수열 입력
    val sequence = br.readLine().split(" ").map { it.toLong() }.toLongArray()

    //앞부분과 뒷부분의 수열로 합 계산
    val frontSums = ArrayList<Long>()
    val backSums = ArrayList<Long>()

    val mid = n / 2
    calculatePartSum(sequence, frontSums, 0, 0, mid)
    calculatePartSum(sequence, backSums, 0, mid, n)

    //답 계산
    frontSums.sort()
    backSums.sort()
    val answer = calculateTargetCount(frontSums, backSums, s)

    //출력
    println(answer)
}

//-- 부분 수열 합 계산 --//
fun calculatePartSum(originalSeq: LongArray, savings: ArrayList<Long>, sum: Long, curIdx: Int, limit: Int) {
    if (curIdx == limit) {
        savings.add(sum)
        return
    }

    //쓰거나 안 쓰거나
    calculatePartSum(originalSeq, savings, sum, curIdx + 1, limit)
    calculatePartSum(originalSeq, savings, sum + originalSeq[curIdx], curIdx + 1, limit)
}

//-- 두 합 배열 조합으로 타겟 도달 가능성 --//
fun calculateTargetCount(front: ArrayList<Long>, back: ArrayList<Long>, target: Int): Long {
    var res = 0L

    var curIdx = 0
    while (curIdx < front.size) {
        res += countWithBinarySearch(back, target - front[curIdx])
        curIdx++
    }

    if (target == 0) res -= 1
    return res
}

//-- 이분 탐색으로 개수 계산 --//
fun countWithBinarySearch(arr: ArrayList<Long>, target: Long): Int {
    //lower bound 계산
    var start = 0
    var end = arr.lastIndex
    var lowerBound = arr.size
    while (start <= end) {
        val mid = (start + end) / 2

        if (arr[mid] >= target) {
            lowerBound = mid
            end = mid - 1
        } else
            start = mid + 1
    }

    //upper bound 계산
    start = 0
    end = arr.lastIndex
    var upperBound = arr.size
    while (start <= end) {
        val mid = (start + end) / 2

        if (arr[mid] > target) {
            upperBound = mid
            end = mid - 1
        } else
            start = mid + 1
    }

    return upperBound - lowerBound
}
