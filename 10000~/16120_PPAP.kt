fun main() {
    //입력 받기
    val str = (readLine() ?: "").toCharArray()

    var cnt = 0
    var isPPAP = true
    var idx = 0
    while(idx in str.indices){
        if(str[idx] == 'P') cnt++ //p 개수 체크
        else{
            if(cnt >= 2 && idx != str.size - 1 && str[idx + 1] == 'P') {
                cnt-- //ppap를 p로 치환
                idx++ //뒤에도 이미 체크함
            }
            else { //ppap 불가
                isPPAP = false
                break
            }
        }
        idx++
    }

    //출력
    if(isPPAP && cnt == 1) println("PPAP")
    else println("NP")
}
