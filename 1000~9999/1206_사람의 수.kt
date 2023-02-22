fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //평균 입력 및 정수 처리
    val averages = IntArray(n)
    repeat(n) {
        val input = br.readLine().split(".")
        val sb = StringBuilder()
        sb.append(input[0]).append(input[1])
        averages[it] = sb.toString().toInt()
    }

    for (cntOfPeople in 1..1000) {
        // 현재 인원수가 분모일 때, 모두 일치하는지 확인
        if (isPossibleCnt(checkCnt = cntOfPeople, averages = averages)) {
            //출력
            println(cntOfPeople)
            break
        }
    }

    br.close()
}

//-- 이 사람 수일 때 가능한 점수가 있는지 확인하는 함수 --//
fun isPossibleCnt(checkCnt: Int, averages: IntArray): Boolean {
    for (avg in averages) {
        var left = 0 ///최소 점수 = 모두가 빵점
        var right = 10 * checkCnt //최대 점수 = 모두가 10점
        var isPossible = false
        while (left <= right) {
            // 총 점수
            val mid = (left + right) / 2
            val currentAvg = (mid * 1000) / checkCnt

            //이 평균이 나올 수 있으면 저장
            if (currentAvg == avg) {
                if (currentAvg > 10 * 1000) 
                    continue
                isPossible = true
                break
            } else if (currentAvg > avg) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        //하나라도 안되는 소수 평균 있으면 실패
        if(!isPossible)  return false
    }
    return true
}
