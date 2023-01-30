data class Rectangle(val leftX: Long, val downY: Long, val rightX: Long, val upY: Long)

fun main() {
    val rectangles = mutableListOf<Rectangle>()
    //입력
    for(i in 0 until 2) {
        val (lx, ly, rx, ry) = (readLine() ?: "").split(" ").map { it.toLong() }
        rectangles.add(Rectangle(lx, ly, rx, ry))
    }

    //출력
    when{
        areTheyFace(rectangles.first(), rectangles.last()) -> println("FACE")
        areTheyLine(rectangles.first(), rectangles.last()) -> println("LINE")
        areTheyPoint(rectangles.first(), rectangles.last()) -> println("POINT")
        else -> println("NULL")
    }
}

fun areTheyFace(rectangle1: Rectangle, rectangle2: Rectangle): Boolean{
    val xRange = rectangle2.leftX - (rectangle1.rightX - rectangle1.leftX) + 1 until rectangle2.rightX
    val yRange = rectangle2.downY - (rectangle1.upY - rectangle1.downY) + 1 until rectangle2.upY

    if(rectangle1.leftX in xRange && rectangle1.downY in yRange)
        return true
    return false
}

fun areTheyLine(rectangle1: Rectangle, rectangle2: Rectangle): Boolean{
    val widthOf1 = (rectangle1.rightX - rectangle1.leftX)
    val heightOf1 = (rectangle1.upY - rectangle1.downY)
    val xRange = rectangle2.leftX + 1 until rectangle2.rightX + widthOf1
    val yRange = rectangle2.downY + 1 until rectangle2.upY + heightOf1

    if(rectangle2.leftX == rectangle1.rightX && rectangle1.upY in yRange)
        return true
    if(rectangle1.leftX == rectangle2.rightX && rectangle1.upY in yRange)
        return true
    if(rectangle2.downY == rectangle1.upY && rectangle1.rightX in xRange)
        return true
    if(rectangle1.downY == rectangle2.upY && rectangle1.rightX in xRange)
        return true

    return false
}

fun areTheyPoint(rectangle1: Rectangle, rectangle2: Rectangle): Boolean{
    val xPointsOfR1 = longArrayOf(rectangle1.leftX, rectangle1.leftX, rectangle1.rightX, rectangle1.rightX)
    val yPointsOfR1 = longArrayOf(rectangle1.downY, rectangle1.upY, rectangle1.downY, rectangle1.upY)
    val xPointsOfR2 = longArrayOf(rectangle2.leftX, rectangle2.leftX, rectangle2.rightX, rectangle2.rightX)
    val yPointsOfR2 = longArrayOf(rectangle2.downY, rectangle2.upY, rectangle2.downY, rectangle2.upY)

    var cnt = 0
    for(i in 0 until 4)
        for(j in 0 until 4)
            if(xPointsOfR1[i] == xPointsOfR2[j] && yPointsOfR1[i] == yPointsOfR2[j])
                cnt++

    return (cnt == 1)
}
