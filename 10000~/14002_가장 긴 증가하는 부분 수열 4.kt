import java.util.*
import kotlin.math.max

fun main() {
    //입력 받기 (각각 길이와 수열)
    val len = (readLine() ?: "0").toInt()
    val seq = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //dp
    val dp = IntArray(len + 1){1}
    for(i in 1 until len){
        for(j in 0 until i){
            if(seq[i] > seq[j])
                dp[i] = max(dp[i], dp[j] + 1)
        }
    }

    //길이 출력
    var ansLen = dp.maxOrNull() ?: 1
    println(ansLen)

    //실제 원소 구해서 출력
    val st = Stack<Int>()
    for(i in len - 1 downTo  0){
        if(ansLen == dp[i]){
            st.push(seq[i])
            ansLen--
        }
    }

    while(!st.isEmpty())
        print("${st.pop()} ")
}
