import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    //상수 입력
    val n = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    //회전초밥 설정 입력
    val rotateSushi = IntArray(n)
    for (i in 0 until n)
        rotateSushi[i] = br.readLine().toInt()

    //연산 후 출력
    println(assumptions(rotateSushi, k, c))
    br.close()
}

//-- 회전초밥 범위 가정 함수 --//
fun assumptions(rotateSushi: IntArray, k: Int, c: Int): Int {
    var answer = 0
    val currentSushiCnt = mutableMapOf<Int, Int>()

    //초기 포인터 설정
    var start = 0
    var end = k - 1
    for(ptr in 0 until k){
        currentSushiCnt[rotateSushi[ptr]] = (currentSushiCnt[rotateSushi[ptr]] ?: 0) + 1
    }

    while(start < rotateSushi.size){
        //현 상황에서 가능한 가장 많은 초밥 개수
        val cur = currentSushiCnt.size + if(currentSushiCnt.keys.contains(c)) 0 else 1
        answer = maxOf(answer, cur)

        //앞 포인터 이동
        currentSushiCnt[rotateSushi[start]] = (currentSushiCnt[rotateSushi[start]] ?: 0) - 1
        if((currentSushiCnt[rotateSushi[start]] ?: 0) <= 0)
            currentSushiCnt.remove(rotateSushi[start])
        start++


        //뒤 포인터 이동
        end = (end + 1) % rotateSushi.size
        currentSushiCnt[rotateSushi[end]] = (currentSushiCnt[rotateSushi[end]] ?: 0) + 1
    }

    return answer
}
