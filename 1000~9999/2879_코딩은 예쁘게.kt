import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    //입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = (br.readLine()).toInt()

    val curTab = IntArray(n)
    val diffTab = IntArray(n)

    var st = StringTokenizer(br.readLine())
    for(i in 0 until n)
        curTab[i] = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    for(i in 0 until n)
        diffTab[i] = st.nextToken().toInt() - curTab[i]

    var answer = 0
    while (true){
        //tab 작업을 해야하는 최초 포인터 위치 구하기
        var ptr = 0
        while (ptr < n && diffTab[ptr] == 0)
            ptr++

        //끝까지 감 -> 추가 작업 필요 없음
        if(ptr == n) break

        //함께 작업할 마지막 포인터 위치 구하기
        val startPtr = ptr
        var common = diffTab[ptr]

        ptr++
        while(ptr < n && common * diffTab[ptr] > 0){
            if(common > 0) common = minOf(common, diffTab[ptr])
            else common = maxOf(common, diffTab[ptr])
            ptr++
        }

        //tab 작업
        for(idx in startPtr until ptr)
            diffTab[idx] -= common

        //답 갱신
        if(common < 0) common = -common
        answer += common
    }

    //출력
    println(answer)
}
