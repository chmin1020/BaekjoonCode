
data class Alphabet(val c: Char, var value: Long = 0L, var notZero: Boolean = false)

val alphabets = arrayOf(
    Alphabet('A'), Alphabet('B'), Alphabet('C'), Alphabet('D'), Alphabet('E'),
    Alphabet('F'), Alphabet('G'), Alphabet('H'), Alphabet('I'), Alphabet('J')
)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //문자열 입력 및 처리
    val strings = mutableListOf<String>()
    for(i in 0 until n){
        with(br.readLine()){
            var curValue = 1L
            for(c in this.lastIndex downTo 0){
                alphabets[this[c] - 'A'].value += curValue
                curValue *= 10

                //맨 앞에 있는 수는 0이 될 수 없음
                if(c == 0)
                    alphabets[this[c] - 'A'].notZero = true
            }
            strings.add(this)
        }
    }

    //알파벳 정렬 및 0 처리
    alphabets.sortBy { -it.value }
    for(i in alphabets.lastIndex downTo 0){
        if(!alphabets[i].notZero){
            val tmp = alphabets[i]

            for(j in i until alphabets.lastIndex)
                alphabets[j] = alphabets[j + 1]
            alphabets[alphabets.lastIndex] = tmp
            break
        }
    }

    //알파벳 적절 연결
    val alphabetMap = mutableMapOf<Char, Int>()
    var realValue = 9
    for(each in alphabets)
        alphabetMap[each.c] = realValue--


    //연결된 값에 따라 숫자 덧셈 계산
    var answer = 0L
    strings.forEach {
        var current = 0L
        var tenVal = 1L

        for(c in it.lastIndex downTo 0){
           current += (alphabetMap[it[c]] ?: 0) * tenVal
           tenVal *= 10
        }
        answer += current
    }

    //출력
    println(answer)
    br.close()
}
