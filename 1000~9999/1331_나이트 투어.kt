import kotlin.math.abs

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val moves = mutableListOf<String>()
    repeat(36){ moves.add(br.readLine()) }

    //판단
    var answer = "Valid"

    if(moves.groupBy { it }.size < 36) //중복 방문 존재
        answer = "Invalid"
    else { //이동을 이상하게
        for (i in moves.indices) {
            val start = moves[i]
            val end = moves[(i + 1) % 36]

            val alphabetDiff = abs(end[0] - start[0])
            val numberDiff = abs(end[1] - start[1])

            if (!(alphabetDiff == 2 && numberDiff == 1) && !(alphabetDiff == 1 && numberDiff == 2)) {
                answer = "Invalid"
                break
            }
        }
    }

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}
