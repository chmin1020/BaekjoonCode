//-- 문자열 모음인지 판단 --//
fun Char.isVowel(): Boolean{
    val vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return (this in vowels)
}

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val answer = mutableListOf<Int>()

    while(true){
        val st = br.readLine().trim()
        if(st == "#") break
        answer.add(st.count{ it.isVowel() })
    }

    //출력
    with(System.out.bufferedWriter()) {
        write(answer.joinToString("\n"))
        flush()
        close()
    }
}
