import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())

    //상수 입력
    val s = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val r1 = st.nextToken().toInt()
    val r2 = st.nextToken().toInt()
    val c1 = st.nextToken().toInt()
    val c2 = st.nextToken().toInt()

    //프랙탈 보드 설정
    val board = Array(r2 - r1 + 1) { IntArray(c2 - c1 + 1) { 0 } }


    //------프랙탈 재귀 함수---------//
    fun fractal(sx: Int, sy: Int, currentN: Int) {
        //출력 범위에 포함되지 않을 시 종료
        if (currentN <= 1 || sx + currentN - 1 < r1 || sx > r2 || sy + currentN - 1 < c1 || sy > c2)
            return

        //등분되는 칸 크기와 중앙 마크 시작점
        val nextN = currentN / n;
        val offset = (currentN - nextN * k) / 2;

        //마킹 영역 설정
        val centerXMin = sx + offset
        val centerXMax = sx + currentN - offset;
        val centerYMin = sy + offset
        val centerYMax = sy + currentN - offset;

        //실제 마킹
        for (x in centerXMin until centerXMax) {
            if (x - r1 !in 0..(r2 - r1)) continue
            for (y in centerYMin until centerYMax) {
                if (y - c1 !in 0..(c2 - c1)) continue
                board[x - r1][y - c1] = 1 //범위에 있으면 표시 }
            }
        }

        //영역별 재귀호출
        for (x in sx until (sx + currentN) step nextN) {
            for (y in sy until (sy + currentN) step nextN) {
                //마킹에 포함 안된 부분 처리
                if (x in centerXMin until centerXMax && y in centerYMin until centerYMax)
                    continue
                fractal(x, y, nextN)
            }
        }
    }

    //프랙탈 재귀 돌리기
    val firstN = (0 until s).fold(1) { res, _ -> res * n }
    fractal(0, 0, firstN)

    //출력
    for (i in board.indices)
        println(board[i].joinToString(""))
    br.close()
}
