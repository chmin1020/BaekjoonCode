fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()

    //연산과 저장
    val answer = mutableListOf<String>()
    repeat(cnt){
        val paper = br.readLine()
        answer.add(if(decidePaperPart(paper)) "YES" else "NO")
    }

    //출력
    with(System.out.bufferedWriter()) {
        write(answer.joinToString("\n"))
        flush()
        close()
    }
}

//-- 종이 나누기 체크 --//
fun decidePaperPart(part: String): Boolean {
    if(part.length == 1) return true

    val leftPart = part.substring(0 until part.length / 2)
    val rightPart = part.substring(part.length / 2 + 1)

    // 양 부분 확인
    if(!decidePaperPart(leftPart)) return false
    if(!decidePaperPart(rightPart)) return false

    //겹치기
    for(idx in leftPart.indices)
        if(leftPart[idx] == rightPart[rightPart.lastIndex - idx])
            return false

    return true
}
