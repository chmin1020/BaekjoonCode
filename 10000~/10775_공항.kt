fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val g = br.readLine().toInt()
    val p = br.readLine().toInt()

    //각 비행기 게이트 범위 입력
    val airplanes = IntArray(p)
    val possibleGates = IntArray(g){ it }
    for(i in 0 until p)
        airplanes[i] = br.readLine().toInt() - 1

    //게이트 탐색
    var answer = 0
    for(gateLimit in airplanes){
        if(!isPossibleGateExist(possibleGates, gateLimit))
            break
        answer++
    }

    //각각 판별 후 출력
    println(answer)
    br.close()
}

//-- 사용할 수 있는 게이트가 있는지 확인하는 함수 --//
fun isPossibleGateExist(info: IntArray, limitGate: Int): Boolean{
    if(findPossibleGate(info, limitGate) < 0)
        return false
    return true
}

//-- 사용할 수 있는 가장 번호가 큰 게이트 찾는 함수 --//
fun findPossibleGate(info: IntArray, curGate: Int): Int{
    //마지막 가능 게이트에 도달했거나 불가능이라고 판단 되었을 때
    if(info[curGate] < 0)
        return info[curGate]

    //가능한 게이트 찾음
    if(curGate == info[curGate]) {
        //이 게이트를 사용하므로 다음 사용 가능 게이트 갱신
        var nextPossibleGate = curGate - 1
        while (nextPossibleGate >= 0 && nextPossibleGate != info[nextPossibleGate])
            nextPossibleGate--
        info[curGate] = nextPossibleGate

        return curGate
    }

    //사용가능 게이트 갱신
    info[curGate] = findPossibleGate(info, info[curGate])
    return info[curGate]
}
