import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    //입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()

    //답 서치
    val answer = parametricSearch(n, k)

    //출력
    println("$answer")
}

//-- 상황에서 가능한 최대 통나무 길이 최솟값을 서치하는 함수 --//
fun parametricSearch(n: Int, k: Int): Long{
    var start:Long = 1
    var end:Long = n * n.toLong()
    var res:Long = 0

    while(start <= end){
        val mid = (start + end) / 2

        //이 수보다 작은 것 개수 구하기
        var smallCnt:Long = 0
        for(i in 1 .. n)
            smallCnt += minOf(mid / i, n.toLong())

        if(smallCnt >= k) {
            res = mid
            end = mid - 1
        }
        else
            start = mid + 1
    }

    return res
}
