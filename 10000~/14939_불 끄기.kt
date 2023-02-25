var answer = Int.MAX_VALUE

//방향 상수
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val lights = Array(10) { BooleanArray(10) }

    //전구 입력
    for(i in 0 until 10)
        br.readLine().forEachIndexed { idx, c -> lights[i][idx] = (c != '#') }

    //첫번째 줄 상황 결정 후 나머지 실행 방식
    setFirstRow(lights, 0, 0)

    //출력
    println(if (answer == Int.MAX_VALUE) -1 else answer)
    br.close()
}

//-- 첫번째 줄 상태 결정 --//
fun setFirstRow(lights: Array<BooleanArray>, cur: Int, soFar: Int) {
    if (cur == 10) {
        //카피 버전 만들기
        val copyLights = Array(10){BooleanArray(10)}
        for(i in 0 until 10)
            for(j in 0 until 10)
                copyLights[i][j] = lights[i][j]

        setRestLights(copyLights, soFar)
        return
    }

    //스위치 누르고, 안 누르고
    switchLamp(lights, 0, cur)
    setFirstRow(lights, cur + 1, soFar + 1)

    switchLamp(lights, 0, cur)
    setFirstRow(lights, cur + 1, soFar)
}

//-- 나머지 줄 결정하고 상태 체크 --//
fun setRestLights(lights: Array<BooleanArray>, soFar: Int){
    var cnt = soFar
    for(i in 1 until 10){
        for(j in 0 until 10){
            if(lights[i - 1][j]){
                switchLamp(lights, i, j)
                cnt++
            }
        }
    }

    //불이 다 꺼져 있으면 성공 (답 갱신)
    if(lights.all { eachRow -> eachRow.all { !it } })
        answer = minOf(answer, cnt)
}

//-- 램프 스위치를 스왑하기 --//
fun switchLamp(lights: Array<BooleanArray>, row: Int, col: Int){
    //본인 스왑
    lights[row][col] = !lights[row][col]

    //주위 불 스왑
    for(d in 0 until 4){
        val nRow = row + directX[d]
        val nCol = col + directY[d]

        if(nRow in 0 until 10 && nCol in 0 until 10)
            lights[nRow][nCol] = !lights[nRow][nCol]
    }
}
