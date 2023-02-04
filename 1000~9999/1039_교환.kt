data class Info(val step: Int, val value: String)

fun main(){
    //입력
    val (n, k) = (readLine() ?: "").split(" ").map { it.toInt() }

    //답
    var answer = -1

    //쉬운 swap 위한 문장 폼
    val strN = n.toString()

    //bfs
    val queue = mutableListOf<Info>()
    queue.add(Info(0, strN))

    //체크 셋
    val checkSet = mutableSetOf<String>()
    var currentStep = 0

    while (queue.isNotEmpty()){
        val cur = queue.removeFirst()
        val intForm = cur.value.toInt()

        if(cur.step > k) break

        //새로운 스텝이면 중복 체크 다시 시작
        if(currentStep != cur.step){
            currentStep++
            checkSet.clear()
        }

        //목표 스텝이면 최댓값 찾기
        if(cur.step == k){
            answer = maxOf(answer, intForm)
            continue
        }

        //중복 체크
        if(checkSet.contains(cur.value)) continue
        checkSet.add(cur.value)

        //두 개의 위치 선택해서 swap
        for(i in cur.value.indices){
            for(j in i + 1 until cur.value.length){
                //swap 문장 생성
                val newStr = makeSwapStr(cur.value, i, j)

                //앞이 0이 아니면 큐에 대입
                if(newStr[0] != '0')
                    queue.add(Info(cur.step + 1, newStr))
            }
        }
    }

    //출력
    println(answer)
}

//-- 각 자리를 바꾼 새 문장 만드는 함수 --//
fun makeSwapStr(cur: String, swapIdx1: Int, swapIdx2: Int): String{
    val newStrMaker = StringBuilder()
    for(idx in cur.indices){
        when(idx){
            swapIdx1 -> newStrMaker.append(cur[swapIdx2])
            swapIdx2 -> newStrMaker.append(cur[swapIdx1])
            else -> newStrMaker.append(cur[idx])
        }
    }
    return newStrMaker.toString()
}
