fun main(){
    //입력
    val n = (readLine() ?: "").toInt()
    val numbers = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //좋은 수 목록 만들기
    val goodMap = mutableMapOf<Int, Int>()
    for(idx1 in 0 until n){
        for(idx2 in idx1 + 1 until n) {
            val candidate = numbers[idx1] + numbers[idx2]
            goodMap[candidate] = (goodMap[candidate] ?: 0) + 1
        }
    }

    //좋은 수 개수 세기
    val zeroCnt = numbers.filter { it == 0 }.count()
    var answer = 0

    for(num in numbers){
        val cnt = goodMap[num] ?: 0

        if(num != 0 && cnt > zeroCnt)
            answer++
        else if(num == 0 && cnt >= zeroCnt)
            answer++
    }

    //출력
    println(answer)
}
