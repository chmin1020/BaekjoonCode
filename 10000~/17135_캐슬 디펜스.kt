import java.util.PriorityQueue
import kotlin.math.abs

var answer = 0
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n, m, d) = br.readLine().split(" ").map { it.toInt() }

    //상황 입력
    val map = Array(n){ IntArray(m) }
    repeat(n){idx->
        map[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    //궁수 시뮬레이션
    for(idx in 0 until m)
        selectArchers(map, mutableListOf(idx), idx + 1, d)


    //출력
    println(answer)
}

//-- 재귀로 궁수를 선택하는 함수 --//
fun selectArchers(map: Array<IntArray>, selected: MutableList<Int>, curIdx: Int, d: Int){
    //3개 선택 완료
    if(selected.size == 3){
        answer = maxOf(answer, simulateDefense(map, selected, d))
        return
    }

    //재귀로 선택
    for(idx in curIdx ..map[0].size) {
        selected.add(idx)
        selectArchers(map, selected, idx + 1, d)
        selected.removeLast()
    }

}

//--해당 상황에서 디펜스 시뮬레이팅 --//
data class Pos(val x: Int, val y: Int)

data class Enemy(val pos: Pos, val dis:Int): Comparable<Enemy>{
    override fun compareTo(other: Enemy): Int {
        if(this.dis == other.dis) return this.pos.y - other.pos.y
        return this.dis - other.dis
    }
}

fun simulateDefense(map: Array<IntArray>, archers: List<Int>, d: Int): Int{
    val deadEnemies = mutableSetOf<Pos>()

    for(row in map.lastIndex downTo 0){
        //각 궁수마다 가장 최적의 적 확인
        val shootEnemies = mutableSetOf<Pos>()
        archers.forEach { col ->
            //무슨 적 쏠지 탐색
            val heap = PriorityQueue<Enemy>()

            //세로거리에 따른 가로거리 범위
            var leftCol = col - (d - 1)
            var rightCol = col + (d - 1)

            //쏠 수 있는 적 모두 탐색
            var curRow = row
            while(curRow >= 0 && leftCol <= rightCol){
                for(curCol in maxOf(0,leftCol)..minOf(map[0].lastIndex, rightCol))
                    if (map[curRow][curCol] == 1 && !deadEnemies.contains(Pos(curRow, curCol)))
                        heap.add(Enemy(Pos(curRow, curCol), abs(row - curRow) + 1 + abs(col - curCol)))
                curRow--
                leftCol++
                rightCol--
            }
            //가장 가까운 적 결정
            if(heap.isNotEmpty())
                shootEnemies.add(heap.peek().pos)
        }

        //죽은 적 갱신
        deadEnemies.addAll(shootEnemies)
    }
    return deadEnemies.size
}
