//포인터는 공유
var ptr = 0
var size = 0

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    size = str.length

    //출력
    with(System.out.bufferedWriter()) {
        write("${strPartLength(str)}")
        flush()
        close()
    }
}

//-- 각 파트별 길이 구하기 --//
fun strPartLength(str: String): Int{
    var len = 0

    while(ptr < size){
        if(str[ptr] == '('){ //새 함수로 내부 길이 가져오기
            val mul = (str[ptr - 1] - '0')
            ptr++
            len--
            len += (mul * strPartLength(str))
        }
        else if(str[ptr] == ')') //함수 끝
            break
        else //일반 숫자
            len++
        ptr++
    }
    return len
}
