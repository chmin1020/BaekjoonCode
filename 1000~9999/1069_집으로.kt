import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    //상수 입력
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    val distance = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))

    val answer =
        if (d <= t) //점프가 더 느린 경우 -> 그냥 걷기
            distance
        else { //점프가 더 빠른 경우
            val jumpCnt = (distance / d).toInt()

            if (jumpCnt < 1) //점프 거리보다 일직선 거리가 짧음 -> 꺾어서 두 번 점프, 한 번 점프하고 뒤돌기, 걷기 중 빠른 것 선택
                minOf(distance, minOf(2.0 * t, t + (d - distance)))
            else //점프 거리보다 일직선 거리가 더 김 -> 점프만으로 이동, 점프 최대한 하고 남은 거리 걷기 중 빠른 것 선택
                minOf((jumpCnt + 1).toDouble() * t, jumpCnt * t + (distance - jumpCnt * d))
        }

    //출력
    println(answer)
    br.close()
}
