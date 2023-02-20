fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //문장 입력
    val strings = mutableListOf<String>()
    for(i in 0 until n)
        strings.add(br.readLine())

    //각각 판별 후 출력
    strings.forEach { println(checkPalindrome(it, true)) }
    br.close()
}

//-- 회문 체크 함수 --//
fun checkPalindrome(str: String, haveChance: Boolean): Int{
    var start = 0
    var end = str.lastIndex

    //투 포인터로 회문 체크
    while (start < end){
        if(str[start] != str[end])
            break
        start++
        end--
    }

    //회문 통과를 못함
    if(start < end){
        if(haveChance){
            val sub1 = str.substring(start + 1..end) //시작점 쪽 문자 제거
            val sub2 = str.substring(start until end) //끝점 쪽 문자 제거

            //제거하고 남은 문장 중 하나라도 회문이면 1
            if(checkPalindrome(sub1, false) == 0 || checkPalindrome(sub2, false) == 0)
                return 1
        }
        return 2
    }
    else //회문 통과
        return 0
}
