import java.util.*

fun main() {
    //입력 받기
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val posVolumes = (readLine()?: "").split(" ").map { it.toInt() }.toIntArray()

    //dp 준비
    val dp = Array(n + 1){ BooleanArray(m + 1){false} }
    dp[0][s] = true

    //한 칸씩 dp로 가능성 확인 계산
    for(i in 0 until n) {
        for(j in 0..m){
            if(!dp[i][j]) continue

            if(j - posVolumes[i] >= 0)
                dp[i + 1][j - posVolumes[i]] = true
            if(j + posVolumes[i] <= m)
                dp[i + 1][j + posVolumes[i]] = true
        }
    }

    //최고 답 출력
    var answer = -1
    for(i in 0..m)
        if(dp[n][i]) answer = i
    println(answer)
}
