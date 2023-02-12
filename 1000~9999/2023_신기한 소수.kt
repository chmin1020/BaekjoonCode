import kotlin.math.sqrt

val answers = mutableListOf<Int>()

fun main(){
    //입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    dfs(0, 0, n)


    //출력
    println(answers.joinToString("\n"))
    br.close()
}

//-- dfs --//
fun dfs(number:Int, cur: Int, limit: Int){
    //자릿수 같으면 소수 체크
    if(cur == limit){
        if(isPrime(number))
            answers.add(number)
        return
    }

    for(i in 0 until 10){
        val candidate = number * 10 + i

        //소수일 때만 다음 단계로 넘어가기
        if(isPrime(candidate))
            dfs(candidate, cur + 1, limit)
    }
}

//-- 소수 판별 함수 --//
fun isPrime(num: Int): Boolean{
    if(num == 0 || num == 1) return false

    val sqrt = sqrt(num.toDouble()).toInt()
    for(i in 2 .. sqrt)
        if(num % i == 0)
            return false
    return true
}
