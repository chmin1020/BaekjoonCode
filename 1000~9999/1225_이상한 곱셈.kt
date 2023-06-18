fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().split(" ")

    var answer = 0L
    a.forEach { ac ->
        b.forEach { bc ->
            answer += (ac.toDigit() * bc.toDigit())
        }
    }

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}

fun Char.toDigit(): Int = this - '0'
