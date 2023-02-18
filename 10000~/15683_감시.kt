import java.util.*

//좌표 데이터 클래스
data class Pos(val x: Int, val y: Int)

//cctv 패턴 클래스
data class CCTV(val pos: Pos, val patternNumber: Int, val selectIdx: Int)

//감시 방향 상수
val directX = intArrayOf(-1, 1, 0, 0)
val directY = intArrayOf(0, 0, -1, 1)

//5개의 감시카메라 패턴
val cctvPatterns = arrayOf(
    arrayOf(arrayOf(0), arrayOf(1), arrayOf(2), arrayOf(3)),
    arrayOf(arrayOf(0, 1), arrayOf(2, 3)),
    arrayOf(arrayOf(0, 3), arrayOf(3, 1), arrayOf(1, 2), arrayOf(2, 0)),
    arrayOf(arrayOf(0, 3, 1), arrayOf(3, 1, 2), arrayOf(1, 2, 0), arrayOf(2, 0, 3)),
    arrayOf(arrayOf(0, 1, 2, 3))
)

var answer = Int.MAX_VALUE
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    //상수 입력
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    //지도 입력
    val cameras = mutableListOf<Pos>()
    val map = Array(n) { IntArray(m) }
    var totalSize = 0
    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
            //cctv 위치는 따로 보관
            if (map[i][j] in 1..5)
                cameras.add(Pos(i, j))

            //사각 지대가 가능한 전체 공간 넓이
            if(map[i][j] == 0)
                totalSize++
        }
    }

    //모든 패턴 탐색
    patternChoice(map, cameras.toTypedArray(), mutableListOf(), totalSize, 0)

    //출력
    println(answer)
    br.close()
}

//-- 재귀를 통한 각 카메라 감시 방향 고르기 --//
fun patternChoice(map: Array<IntArray>, cameras: Array<Pos>, cctvInfo: MutableList<CCTV>, totalSize: Int, idx: Int) {
    if (idx == cameras.size) {
        //실제 카메라 돌리기 시뮬레이션
        answer = minOf(answer, cctvSimulation(map, cctvInfo, totalSize))
        return
    }

    val curPatternNumber = map[cameras[idx].x][cameras[idx].y] - 1
    for (i in cctvPatterns[curPatternNumber].indices) {
        cctvInfo.add(CCTV(cameras[idx], curPatternNumber, i))
        patternChoice(map, cameras, cctvInfo, totalSize, idx + 1)
        cctvInfo.removeLast()
    }
}

//-- cctv 정보에 따라 시뮬레이션을 돌리고 사각지대 넓이 반환 --//
fun cctvSimulation(map: Array<IntArray>, cctvInfo: MutableList<CCTV>, totalSize: Int): Int {
    val checked = Array(map.size) { BooleanArray(map[0].size) { false } }
    var checkArea = 0

    //각 cctv 별개 작동 시작
    cctvInfo.forEach {
        //선택된 패턴대로 감시
        cctvPatterns[it.patternNumber][it.selectIdx].forEach { direct ->
            var curX = it.pos.x + directX[direct]
            var curY = it.pos.y + directY[direct]

            //감시하고자 하는 곳이 맵 영역 내부이고, 벽이 아닌 동안
            while (curX in map.indices && curY in map[0].indices && map[curX][curY] != 6) {
                //최초 체크 -> 체크 영역 카운트 증가
                if (map[curX][curY] == 0 && !checked[curX][curY]) {
                    checkArea++
                    checked[curX][curY] = true
                }

                curX += directX[direct]
                curY += directY[direct]
            }
        }
    }
    return totalSize - checkArea
}
