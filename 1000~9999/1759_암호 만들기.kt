fun main() {
    //입력
    val (l,c) = (readLine() ?: "0 0").split(" ").map { it.toInt() }

    val alphabets = (readLine() ?: "").split(" ").map { it[0] }
    val used = BooleanArray(c){false}
    val answers = mutableListOf<String>()


    //--가능한 경우의 수를 찾는 dfs--//
    fun dfs(combination: String){
        if(combination.length == l){
            //모음, 자음
            var vowelCnt = 0
            var consonantCnt = 0

            combination.forEach {
                if(isVowel(it)) vowelCnt++
                else consonantCnt++
            }

            if(vowelCnt >= 1 && consonantCnt >= 2)
                answers.add(combination)
            return
        }

        alphabets.forEachIndexed { index, c ->
            if(!used[index] && (combination.isBlank() || combination.last() < c)) {
                used[index] = true
                dfs(combination + c)
                used[index] = false
            }
        }
    }

    //탐색 수행
    dfs("")
    answers.sort()

    //출력
    println(answers.joinToString("\n"))
}

fun isVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
