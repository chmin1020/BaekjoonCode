fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    //수열 입력
    val seq = br.readLine().split(" ").map { it.toLong() }

    //누적 합 배열 설정
    val restCnt = LongArray(m) {0}
    val lessPartnerCnt = LongArray(n)
    val cumulative = LongArray(n).also {
        it[0] = seq[0] % m
        lessPartnerCnt[0] = restCnt[it[0].toInt()]++
    }
    for (idx in 1 until n) {
        cumulative[idx] = (cumulative[idx - 1] + seq[idx]) % m
            lessPartnerCnt[idx] = restCnt[cumulative[idx].toInt()]++
    }

    //누적합으로 계산
    var answer = 0L
    answer += restCnt[0]
    answer += lessPartnerCnt.fold(0L){tot, it -> tot + it}

    //출력
    println(answer)
}
