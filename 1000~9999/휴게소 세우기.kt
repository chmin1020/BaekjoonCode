import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    //입력
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    //최초 휴게소들 위치 정렬
    val rests = IntArray(n + 2)
    st = StringTokenizer(br.readLine())
    rests[0] = 0
    for(i in 1 .. n)
        rests[i] = st.nextToken().toInt()
    rests[n + 1] = l
    rests.sort()

    //최적의 간격 서치
    val bestMin = parametricSearch(rests, m, l)

    //출력
    println(bestMin)
}

//-- 휴게소 사이 적정 간격을 서치하는 함수 --//
fun parametricSearch(rests: IntArray, targetCnt: Int, len: Int): Int{
    var start = 1
    var end = len - 1

    while (start < end){
        val gap = (start + end) / 2

        var curCnt = 0
        for(i in 1 until rests.size){
            val interval = rests[i] - rests[i - 1]

            val add = (interval / gap) - if(interval % gap == 0) 1 else 0
            curCnt += add
        }

        if(curCnt > targetCnt)
            start = gap + 1
        else
            end = gap
    }
    
    return end
}
