fun main() {
    //입력 받기
    val possibles = (readLine() ?: "0").toCharArray()
    val cipher = (readLine() ?: "0").toCharArray()

    var answer = 0

    //~번째인지 맵 만들기
    val whichIndex = possibles.mapIndexed{ idx, it -> it to idx + 1}.toMap()

    var cnt = 1
    for(idx in cipher.size - 1 downTo 0){
        //실제로 곱하기
        val step = (cnt * (whichIndex[cipher[idx]] ?: 0)) % 900528

        //자릿수에 따라 다음에 곱해야 하는 크기 결정
        cnt = (cnt * possibles.size) % 900528

        //누적합
        answer = (answer + step) % 900528
    }
    print(answer)
}
