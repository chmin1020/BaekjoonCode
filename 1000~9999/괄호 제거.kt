import java.util.*

//필요한 콜렉션들
val parenthesisPairs = mutableListOf<Pair<Int, Int>>()
val possibleExpressions = mutableSetOf<String>()

fun main(){
    //입력
    val expression = (readLine()?:"")

    //괄호쌍 체크
    checkParenthesisPair(expression)

    //괄호쌍 각각 제거한 식들 만들기
    val pairsArray = parenthesisPairs.toTypedArray()
    val used = BooleanArray(expression.length){true}
    makePossibleExpressions(pairsArray, used, expression, 0)

    //출력
    val answers = possibleExpressions.toTypedArray()
    answers.sort()
    println(answers.joinToString("\n"))
}

//-- 괄호쌍 체크 함수 --//
fun checkParenthesisPair(expression: String){
    //스택을 통한 pair 찾기
    val stack = Stack<Int>()
    expression.forEachIndexed { idx, ch ->
        if(ch == '(')
            stack.push(idx)
        if(stack.isNotEmpty() && ch == ')')
            parenthesisPairs.add(Pair(stack.pop(), idx))
    }
}

//-- 괄호쌍 제거 식 조합 함수(재귀) --//
fun makePossibleExpressions(pairs: Array<Pair<Int, Int>>, used: BooleanArray, expression: String, idx: Int){
    //조합 만들어서 저장
    if(idx > pairs.lastIndex){
        val sb = StringBuilder()
        used.forEachIndexed { index, b -> if(b) sb.append(expression[index]) }

        //모두 안 없앤 결과는 제외
        if(sb.length != expression.length)
            possibleExpressions.add(sb.toString())
        return
    }

    //괄호 안 없애기
    makePossibleExpressions(pairs, used, expression, idx + 1)

    //괄호 없애기
    used[pairs[idx].first] = false
    used[pairs[idx].second] = false
    makePossibleExpressions(pairs, used, expression, idx + 1)
    used[pairs[idx].first] = true
    used[pairs[idx].second] = true
}
