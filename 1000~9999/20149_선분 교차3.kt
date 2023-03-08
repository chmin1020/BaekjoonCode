data class Pos(val x: Long, val y: Long)
const val INF = Double.MAX_VALUE

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
    val com123 = ccw(pos1, pos2, pos3)
    val com124 = ccw(pos1, pos2, pos4)
    val com341 = ccw(pos3, pos4, pos1)
    val com342 = ccw(pos3, pos4, pos2)
    val res1 = com123 * com124
    val res2 = com341 * com342

    //각 선분의 기울기 파악
    val slope1 = getSlope(pos1, pos2)
    val slope2 = getSlope(pos3, pos4)

    //결과에 따라 답 출력
    if (res1 < 0 && res2 <= 0 || res1 <= 0 && res2 < 0) { //평행하지 않은 선 두 개가 한 점에서 겹친다
        println(1)
        calculateIntersectPoint(slope1, slope2, pos1, pos3)
    }
    else if(res1 == 0 && res2 == 0) { //적어도 3점이 같은 선에 있다
        if (com123 == 0 && com124 == 0 && com341 == 0 && com342 == 0) { //완전히 일직선에 있는 두 선분
            val n = getCrossStatus(arrayOf(pos1, pos2, pos3, pos4))
            println(if (n > 0) 1 else 0)

            //선분 끝에서 만남
            if (n == 2) {
                if (pos1.x == pos3.x && pos1.y == pos3.y || pos1.x == pos4.x && pos1.y == pos4.y)
                    println("${pos1.x} ${pos1.y}")
                else if (pos2.x == pos3.x && pos2.y == pos3.y || pos2.x == pos4.x && pos2.y == pos4.y)
                    println("${pos2.x} ${pos2.y}")
            }
        }
        else { //그냥 두 선에 공통인 점이 하나 있다.
            println(1)
            if (pos1.x == pos3.x && pos1.y == pos3.y || pos1.x == pos4.x && pos1.y == pos4.y)
                println("${pos1.x} ${pos1.y}")
            else if (pos2.x == pos3.x && pos2.y == pos3.y || pos2.x == pos4.x && pos2.y == pos4.y)
                println("${pos2.x} ${pos2.y}")
        }
    }
    else
        println(0)
}

//-- 외적 곱을 통해 결과의 부호로 세 점의 방향성을 체크 --//
fun ccw(dot1: Pos, dot2: Pos, dot3: Pos): Int {
    val plus = dot1.x * dot2.y + dot2.x * dot3.y + dot3.x * dot1.y
    val minus = dot2.x * dot1.y + dot3.x * dot2.y + dot1.x * dot3.y

    return when {
        plus - minus > 0 -> 1
        plus - minus < 0 -> -1
        else -> 0
    }
}

//-- 두 선분 연결된 방식을 구하는 과정 --//
fun getCrossStatus(p: Array<Pos>): Int {
    val line1MinVal: Long
    val line1MaxVal: Long
    val line2MinVal: Long
    val line2MaxVal: Long

    if (p[0].x == p[1].x) {
        line1MinVal = minOf(p[0].y, p[1].y)
        line1MaxVal = maxOf(p[0].y, p[1].y)
        line2MinVal = minOf(p[2].y, p[3].y)
        line2MaxVal = maxOf(p[2].y, p[3].y)
    } else {
        line1MinVal = minOf(p[0].x, p[1].x)
        line1MaxVal = maxOf(p[0].x, p[1].x)
        line2MinVal = minOf(p[2].x, p[3].x)
        line2MaxVal = maxOf(p[2].x, p[3].x)
    }

    //선분 끝에서 만나면 2, 무수히 많은 점에서 겹쳐지면 1, 아예 겹치지 않으면 0
    return if (line1MinVal == line2MaxVal || line1MaxVal == line2MinVal) 2 else if (line1MinVal < line2MaxVal && line2MinVal < line1MaxVal) 1 else 0
}

//-- 기울기 구하기 --//
fun getSlope(dot1: Pos, dot2: Pos): Double{
    if(dot1.x == dot2.x)
        return INF

    return (dot1.y - dot2.y) / (dot1.x - dot2.x).toDouble()
}

//-- 선분 교차점을 구하는 과정 --//
fun calculateIntersectPoint(slope1: Double, slope2: Double, dot1: Pos, dot3: Pos) {
    val x:Double
    val y:Double

    if (slope1 == INF) {
        x = dot1.x.toDouble()
        y = slope2 * (x - dot3.x) + dot3.y
    }
    else if (slope2 == INF) {
        x = dot3.x.toDouble()
        y = slope1 * (x - dot1.x) + dot1.y
    }
    else {
        x = (slope1 * dot1.x - slope2 * dot3.x + dot3.y - dot1.y) / (slope1 - slope2)
        y = slope1 * (x - dot1.x) + dot1.y
    }

    println("$x $y")
}
