import java.util.*

fun main() {
    //입력 받기
    var st = StringTokenizer(readLine() ?: "0")
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    //배열 완성
    val array = Array(n + 1){IntArray(m + 1){0} }
    for(i in 1..n) {
        st = StringTokenizer(readLine() ?: "0")
        for (j in 1..m)
            array[i][j] = st.nextToken().toInt()
    }

    //배열을 가로 누적합 배열로
    for(i in 1..n)
        for(j in 1..m)
            array[i][j] += array[i][j - 1]


    val orderCnt = (readLine() ?: "0").toInt()
    for(i in 0 until orderCnt){
        st = StringTokenizer(readLine() ?: "0")
        val startX = st.nextToken().toInt()
        val startY = st.nextToken().toInt()
        val endX = st.nextToken().toInt()
        val endY = st.nextToken().toInt()

        var answer = 0
        for(j in startX..endX)
            answer += (array[j][endY] - array[j][startY - 1])
        println(answer)
    }
}
