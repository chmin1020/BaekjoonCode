import java.util.*

data class Order(val where: Char, val clockwise: Boolean)
data class RotateInfo(val where: Char, val rowSeq: List<Int>, val colSeq: List<Int>)

class Cube {
    companion object {
        val frontRotate = arrayOf(
            RotateInfo('U', listOf(2), listOf(0, 1, 2)),
            RotateInfo('R', listOf(0, 1, 2), listOf(0)),
            RotateInfo('D', listOf(0), listOf(2, 1, 0)),
            RotateInfo('L', listOf(2, 1, 0), listOf(2)),
            RotateInfo('U', listOf(2), listOf(0, 1, 2))
        )
        val backRotate = arrayOf(
            RotateInfo('U', listOf(0), listOf(0, 1, 2)),
            RotateInfo('L', listOf(2, 1, 0), listOf(0)),
            RotateInfo('D', listOf(2), listOf(2, 1, 0)),
            RotateInfo('R', listOf(0, 1, 2), listOf(2)),
            RotateInfo('U', listOf(0), listOf(0, 1, 2))
        )
        val upRotate = arrayOf(
            RotateInfo('F', listOf(0), listOf(0, 1, 2)),
            RotateInfo('L', listOf(0), listOf(0, 1, 2)),
            RotateInfo('B', listOf(0), listOf(0, 1, 2)),
            RotateInfo('R', listOf(0), listOf(0, 1, 2)),
            RotateInfo('F', listOf(0), listOf(0, 1, 2))
        )
        val downRotate = arrayOf(
            RotateInfo('F', listOf(2), listOf(0, 1, 2)),
            RotateInfo('R', listOf(2), listOf(0, 1, 2)),
            RotateInfo('B', listOf(2), listOf(0, 1, 2)),
            RotateInfo('L', listOf(2), listOf(0, 1, 2)),
            RotateInfo('F', listOf(2), listOf(0, 1, 2))
        )
        val leftRotate = arrayOf(
            RotateInfo('U', listOf(0, 1, 2), listOf(0)),
            RotateInfo('F', listOf(0, 1, 2), listOf(0)),
            RotateInfo('D', listOf(0, 1, 2), listOf(0)),
            RotateInfo('B', listOf(2, 1, 0), listOf(2)),
            RotateInfo('U', listOf(0, 1, 2), listOf(0))
        )
        val rightRotate = arrayOf(
            RotateInfo('U', listOf(0, 1, 2), listOf(2)),
            RotateInfo('B', listOf(2, 1, 0), listOf(0)),
            RotateInfo('D', listOf(0, 1, 2), listOf(2)),
            RotateInfo('F', listOf(0, 1, 2), listOf(2)),
            RotateInfo('U', listOf(0, 1, 2), listOf(2))
        )
    }

    //큐브 6개 면 상태
    private val cubeStateMap = mutableMapOf(
        'F' to Array(3) { CharArray(3) { 'r' } },
        'B' to Array(3) { CharArray(3) { 'o' } },
        'U' to Array(3) { CharArray(3) { 'w' } },
        'D' to Array(3) { CharArray(3) { 'y' } },
        'L' to Array(3) { CharArray(3) { 'g' } },
        'R' to Array(3) { CharArray(3) { 'b' } }
    )

    //큐브 회전
    fun rotate(order: Order) {
        //회전 정보에 맞는 적절한 것들 가져와서 설정
        val rotateShape = cubeStateMap[order.where]
        val rotateWay = when (order.where) {
            'F' -> frontRotate
            'B' -> backRotate
            'U' -> upRotate
            'D' -> downRotate
            'L' -> leftRotate
            else -> rightRotate //r
        }
        val rotateDirect = if (order.clockwise) 1 else -1
        var step = if (order.clockwise) 0 else 4
        val end = if (order.clockwise) 5 else -1

        //실제 회전(값 옮기기)
        val tmp = charArrayOf('e', 'e', 'e')
        while (step != end) {
            cubeStateMap[rotateWay[step].where]?.let { shape ->
                var idx = 0
                for (i in rotateWay[step].rowSeq) {
                    for (j in rotateWay[step].colSeq) {
                        val swap = shape[i][j]
                        shape[i][j] = tmp[idx]
                        tmp[idx++] = swap
                    }
                }
            }
            step += rotateDirect
        }
        selfRotate(rotateShape!!, order.clockwise)
    }

    //윗면 출력
    fun printUp() {
        cubeStateMap['U']?.forEach {
            println(it.joinToString(""))
        }
    }

    private fun selfRotate(shape: Array<CharArray>, clockwise: Boolean) {
        //회전 적용한 가장 면 만들기
        val newShape = Array(3) { CharArray(3) }
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (clockwise) newShape[i][j] = shape[2 - j][i]
                else newShape[i][j] = shape[j][2 - i]
            }
        }

        //회전한 모습 적용
        for (i in 0 until 3)
            for (j in 0 until 3)
                shape[i][j] = newShape[i][j]
    }
}

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    //테스트 케이스
    for (i in 0 until tc) {
        //설정
        br.readLine()
        val st = StringTokenizer(br.readLine())
        val cube = Cube()

        //명령어 하나씩 수행
        while (st.hasMoreTokens()) {
            val input = st.nextToken()
            val where = input[0]
            val isClockwise = (input[1] == '+')

            //실제 큐브 돌리기
            cube.rotate(Order(where, isClockwise))
        }

        //큐브 윗면 출력
        cube.printUp()
    }
    br.close()
}
