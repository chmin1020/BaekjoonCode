lateinit var str: String
var n = 0
lateinit var words: Array<String>
val lengthMap = mutableMapOf<Int, MutableList<String>>()

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력(문장과 n)
    str = br.readLine()
    n = br.readLine().toInt()

    //입력(각 단어)
    words = Array(n) { "" }
    for (i in 0 until n) {
        val word = br.readLine()
        words[i] = word
        
        //단어 개수에 따라 미리 분류
        if (lengthMap[word.length] == null)
            lengthMap[word.length] = mutableListOf()
        lengthMap[word.length]?.add(word)
    }

    //내부 계산 및 출력
    println(simulation())
    br.close()
}

fun simulation(): Int {
    val dp = IntArray(str.length){Int.MAX_VALUE}
    val possibleStartIndexes = mutableSetOf(0)

    for(curPtr in str.indices){ //각 인덱스에서 검사
        for(start in 0..curPtr){
            //단어가 시작 가능한 위치가 아니거나 길이가 같은 단어 후보가 없음
            if(!possibleStartIndexes.contains(start) || lengthMap[curPtr - start + 1] == null) continue

            //새로 만든 단어
            val partWord = str.substring(start..curPtr)

            lengthMap[curPtr - start + 1]?.forEach { eachWord->
                //알파벳 개수 맞는지 비교
                val sorted1 = partWord.toCharArray()
                val sorted2 = eachWord.toCharArray()
                sorted1.sort()
                sorted2.sort()

                //알파벳 구성요소도 같음 -> 비용 계산
                if(sorted1.filterIndexed { index1, c1 -> c1 == sorted2[index1] }.count() == sorted1.size) {
                    val curCost = partWord.filterIndexed { index2, c2 -> c2 != eachWord[index2] }.count()
                    val beforeCost = if(start == 0) 0 else dp[start - 1]
                    dp[curPtr] = minOf(dp[curPtr], beforeCost + curCost)

                    //새 단어 시작 가능 위치에 현재 위치 다음을 추가
                    possibleStartIndexes.add(curPtr + 1)
                }
            }
        }
    }
    
    //마지막에 가능한 최소 비용 or -1
    return if(dp.last() == Int.MAX_VALUE) -1 else dp.last()
}
