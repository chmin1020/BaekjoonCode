data class Pos(val x: Long, val y: Long)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //두 선분 입력
    val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = br.readLine().split(" ").map { it.toLong() }
    val pos1 = Pos(x1, y1)
    val pos2 = Pos(x2, y2)
    val pos3 = Pos(x3, y3)
    val pos4 = Pos(x4, y4)

    //두 외적곱의 부호 파악
    val res1 = ccw(pos1, pos2, pos3) * ccw(pos1, pos2, pos4)
    val res2 = ccw(pos3, pos4, pos1) * ccw(pos3, pos4, pos2)

    //결과에 따라 답 출력
    if(res1 <= 0 && res2 <= 0){
        if(res1 == 0 && res2 == 0){ //같은 직선 상에 있음
            if(isInRange(pos1, pos2, pos3) || isInRange(pos1, pos2, pos3))
                println(1)
            else if(isInRange(pos3, pos4, pos1) || isInRange(pos3, pos4, pos2))
                println(1)
            else //겹쳐지지 않음
                println(0)
        }
        else //교차점이 있음
            println(1)
    }
    else
        println(0)
}

//-- 외적 곱을 통해 결과의 부호로 세 점의 방향성을 체크 --//
fun ccw(dot1: Pos, dot2: Pos, dot3: Pos): Int{
    val plus = dot1.x * dot2.y + dot2.x * dot3.y + dot3.x * dot1.y
    val minus = dot2.x * dot1.y + dot3.x * dot2.y + dot1.x * dot3.y

    return when{
        plus - minus > 0 -> 1
        plus - minus < 0 -> -1
        else -> 0
    }
}

//-- 두 점 범위 사이 포함 여부를 구하는 과정 --//
fun isInRange(dot1: Pos, dot2: Pos, targetDot: Pos): Boolean{
    val xRange = minOf(dot1.x, dot2.x)..maxOf(dot1.x, dot2.x)
    val yRange = minOf(dot1.y, dot2.y)..maxOf(dot1.y, dot2.y)

    return (targetDot.x in xRange && targetDot.y in yRange)
}
