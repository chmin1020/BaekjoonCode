fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()
    val factories = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //변수 설정
    var restCnt = factories.filter { it != 0 }.count()
    var answer = 0

    //다 0 될 때까지 greedy
    var idx = 0
    while (idx < n){
        //0은 건너 뛰기
        if(factories[idx] == 0) {
            idx++
            continue
        }

        if(--factories[idx] == 0) restCnt--

        if(idx < n - 1 && factories[idx + 1] != 0 && factories[idx] + 1 <= factories[idx + 1]){ //2개 연속
            if(--factories[idx + 1] == 0) restCnt--

            if(idx < n - 2 && factories[idx + 2] != 0 && factories[idx + 1] + 1 <= factories[idx + 2]){ //3개 연속
                if(--factories[idx + 2] == 0) restCnt--
                answer += 7
            }
            else
                answer += 5
        }
        else
            answer += 3
    }

    //출력
    println(answer)
}
