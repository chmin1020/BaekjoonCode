import kotlin.math.max

fun main() {
    val directPairs = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    var cd = 0
    var cx = 0
    var cy = 0

    //입력
    readLine()
    val path = readLine() ?: ""

    //리스트 채우기
    val possibleList = mutableListOf(Pair(0,0))

    //앞으로 나아가며 리스트 채우는 과정
    fun forward(addPair: Pair<Int, Int>){
        cx += addPair.first
        cy += addPair.second
        possibleList.add(Pair(cx, cy))
    }
    //각 명령을 따르는 과정
    fun doOrder(order: Char){
        when(order){
            'F' -> forward(directPairs[cd])
            'R' -> cd = (cd + 1) % 4
            'L' -> cd = if(cd == 0) 3 else cd - 1
        }
    }

    for(ch in path)
        doOrder(ch)

    //모든 영역을 일반 좌표로 옮기기
    val possibleArr = possibleList.toTypedArray()

    fun setSpotRange() {
        val minX = possibleList.minByOrNull { it.first }?.first ?: 0
        val minY = possibleList.minByOrNull { it.second }?.second ?: 0

        for(i in possibleArr.indices)
            possibleArr[i] = Pair(possibleArr[i].first - minX, possibleArr[i].second - minY)
    }
    setSpotRange()

    //답을 위한 배열 생성
    val maxX = possibleArr.maxByOrNull { it.first }?.first ?: 0
    val maxY = possibleArr.maxByOrNull { it.second }?.second ?: 0
    val answerArr = Array(maxX + 1){ CharArray(maxY + 1){'#'} }
    possibleArr.forEach { answerArr[it.first][it.second] = '.' }

    //출력
    for(i in answerArr.indices){
        for(j in answerArr[0].indices)
            print(answerArr[i][j])
        println()
    }
}
