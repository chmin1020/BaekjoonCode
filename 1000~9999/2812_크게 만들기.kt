import java.util.LinkedList

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    //숫자 입력
    val number = br.readLine()

    //스택에 쌓으면서 작은 것들 버림
    val answers = LinkedList<Char>()
    var cnt = 0
    number.forEach {
        while(cnt < k && answers.isNotEmpty() && answers.first() < it){
            answers.removeFirst()
            cnt++
        }
        answers.addFirst(it)
    }

    //뒤에 것들 빼기
    while(answers.size > n -k)
        answers.removeFirst()
    answers.reverse()


    //출력
    println(answers.joinToString(""))
}
