import java.util.Stack

fun main() {
    //입력
    readLine()
    val towers = (readLine() ?: "").split(" ").map { it.toInt() }

    val answers = mutableListOf<Int>()

    //stack 통해 답 생성
    val stack = Stack<Int>()
    towers.forEachIndexed { index, it ->
        //자신 좌측의 더 작은 타워는 무시
        while (stack.isNotEmpty() && towers[stack.peek()] < it)
            stack.pop()

        //더 큰 타워 없으면 0, 아니면 더 큰 타워
        if(stack.isEmpty()) answers.add(0)
        else answers.add(stack.peek() + 1)

        stack.add(index)
    }

    //출력
    println(answers.joinToString(" "))
}
