fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    val str = br.readLine().trim()
    val aCnt = str.count { it == 'a' }

    //답 구하기
    val answer = getAnswer(str, aCnt)

    //출력
    with(System.out.bufferedWriter()){
        write("$answer\n")
        flush()
        close()
    }
}

//-- 슬라이딩 윈도우 방식으로 b 최솟값 세기 --//
fun getAnswer(str: String, aCnt: Int): Int{
    var bCnt = 0
    for(idx in 0 until aCnt)
        bCnt += if(str[idx] == 'b') 1 else 0
    var ret = bCnt

    var start = 1
    while (start > 0){
        //앞 글자 빼고 뒤 글자 더하기
        bCnt -= if(str[start - 1] == 'b') 1 else 0
        bCnt += if(str[(start + aCnt - 1) % str.length] == 'b') 1 else 0

        ret = minOf(ret, bCnt)
        start = (start + 1) % str.length
    }
    return ret
}
