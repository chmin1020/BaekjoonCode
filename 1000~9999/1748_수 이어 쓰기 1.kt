fun main(){
    //입력
    val n = (readLine() ?: "").toInt()

    //답 연산
    var answer = 0
    for(i in 1 .. n)
        answer += getDigitCnt(i)

    //출력
    println(answer)
}

//-- 숫자 개수 알려주는 함수 --//
fun getDigitCnt(num: Int): Int{
    return when(num){
        in 1..9 -> 1
        in 10..99 -> 2
        in 100..999 -> 3
        in 1000..9999 -> 4
        in 10000..99999 -> 5
        in 100000..999999 -> 6
        in 1000000..9999999 -> 7
        in 10000000..99999999 -> 8
        else -> 9
    }
}
