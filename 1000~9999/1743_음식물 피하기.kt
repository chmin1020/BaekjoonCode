import java.util.*

fun main() {
    //실제 풀이
    fun solution(n: Int, m: Int, info: List<IntArray>){
        var answer = 0
        //지도 만들기
        val hall = Array(n){BooleanArray(m){false}}
        info.forEach{ hall[it[0] - 1][it[1] - 1] = true}


        //bfs로 답 체크 시작
        val checked = Array(n){BooleanArray(m){false}}
        val qu:Queue<Pair<Int, Int>> = LinkedList()

        val directX = intArrayOf(-1, 1, 0, 0)
        val directY = intArrayOf(0, 0, -1, 1)
        for(i in 0 until n){
            for(j in 0 until m){
                //체크 안된 부분부터 탐방 시작
                if(!checked[i][j] && hall[i][j]){
                    checked[i][j] = true
                    qu.add(Pair(i, j))
                    var cnt = 0

                    //연속된 부분 없을 때까지
                    while (qu.isNotEmpty()){
                        cnt++
                        val cur = qu.poll()

                        //4방향 탐방
                        for(d in 0..3){
                            val nx = cur.first + directX[d]
                            val ny = cur.second + directY[d]

                            if(nx in 0 until n && ny in 0 until m && !checked[nx][ny] && hall[nx][ny]) {
                                checked[nx][ny] = true
                                qu.add(Pair(nx, ny))
                            }
                        }
                    }
                    answer = maxOf(answer, cnt)
                }
            }
        }

        println(answer)
    }

    //입력 받아서 풀이 함수 실행
    val inputs = (readLine() ?: "0").split(" ").map { it.toInt() }.toIntArray()
    val infoList = mutableListOf<IntArray>()
    for(i in 0 until inputs[2])
        infoList.add((readLine()?:"0").split(" ").map{ it.toInt() }.toIntArray())

    solution(inputs[0], inputs[1], infoList)
}
