import kotlin.math.pow

//3시, 9시 방향 구하기 / 시계, 반시계 방향 돌리기
fun getEast(start: Int): Int = (start + 2) % 8
fun getWest(start: Int): Int = if(start - 2 >= 0) start -2 else start + 6
fun rotateClockwise(cur: Int): Int = if(cur - 1 >= 0) cur - 1 else 7
fun rotateCounterClockwise(cur: Int): Int = (cur + 1) % 8

fun main() {
    //톱니바퀴 입력 받기
    val gears = Array(4){CharArray(8)}
    val gearStarts = IntArray(4){0}
    for(i in 0..3)
        (readLine() ?: " ").toCharArray().forEachIndexed{idx, it -> gears[i][idx] = it}

    //회전 명령 입력 받고 수행
    val orderCnt = (readLine() ?: "0").toInt()
    for(i in 0 until orderCnt){
        val eachOrder = (readLine() ?: "1 1").split(" ").map { it.toInt() }.toIntArray()

        var cur = eachOrder[0] - 1
        var beforeWest = getWest(gearStarts[cur])
        var beforeEast = getEast(gearStarts[cur])
        //--본인 회전
        if(eachOrder[1] == 1) //시계 방향
            gearStarts[cur] = rotateClockwise(gearStarts[cur])
        else //반시계 방향
            gearStarts[cur] = rotateCounterClockwise(gearStarts[cur])

        //--나머지 회전
        var beforeDirect = eachOrder[1]

        //왼쪽
        cur = eachOrder[0] - 2
        while(cur >= 0){
            //두 극이 다르면 회전
            beforeDirect =
                if(gears[cur][getEast(gearStarts[cur])] != gears[cur + 1][beforeWest]){
                    beforeWest = getWest(gearStarts[cur])
                    if(beforeDirect == 1) { //반시계
                        gearStarts[cur] = rotateCounterClockwise(gearStarts[cur])
                        -1
                    }
                    else { //시계
                        gearStarts[cur] = rotateClockwise(gearStarts[cur])
                        1
                    }
                }
                else
                    break
            cur--
        }

        //오른쪽
        beforeDirect = eachOrder[1]
        cur = eachOrder[0]
        while(cur < 4){
            //두 극이 다르면 회전
            beforeDirect =
                if(gears[cur][getWest(gearStarts[cur])] != gears[cur - 1][beforeEast]){
                    beforeEast = getEast(gearStarts[cur])
                    if(beforeDirect == 1) { //반시계
                        gearStarts[cur] = rotateCounterClockwise(gearStarts[cur])
                        -1
                    }
                    else { //시계
                        gearStarts[cur] = rotateClockwise(gearStarts[cur])
                        1
                    }
                }
                else
                    break
            cur++
        }
    }
    
    //출력
    var answer = 0
    for(i in 0 until 4)
        if (gears[i][gearStarts[i]] == '1')
            answer += (2.0).pow(i).toInt()
    println(answer)
}
