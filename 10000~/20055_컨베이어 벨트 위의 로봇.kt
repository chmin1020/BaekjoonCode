fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val belt = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val answer = simulate(belt, n, k)

    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}

//-- 벨트 돌리기 시뮬레이션 --//
fun simulate(belt: IntArray, n: Int, k: Int): Int{
    val len = 2 * n
    var cnt = 1
    var inPos = 0
    var outPos = n - 1

    val occupied = BooleanArray(len){false}
    val robots = mutableListOf<Int>()

    while (true) {
        //벨트가 회전 (포인트 이동)
        inPos = if(inPos  == 0) len - 1 else inPos - 1
        outPos = if(outPos  == 0) len - 1 else outPos - 1

        //로봇 내리기
        robots.removeIf { it == outPos }
        occupied[outPos] = false

        //가장 먼저 올라간 로봇부터 이동 (내구도 1 이상 남은 곳으로)
        robots.forEachIndexed { idx, it ->
            val nextIdx = (it + 1) % len
            if(belt[nextIdx] > 0 && !occupied[nextIdx]) {
                occupied[it] = false
                occupied[nextIdx] = true
                belt[nextIdx]--
                robots[idx] = nextIdx
            }
        }

        //로봇 내리기
        robots.removeIf { it == outPos }
        occupied[outPos] = false

        //새 로봇 놓기 (내구도 1 이상이면)
        if(belt[inPos] > 0 && !occupied[inPos]){
            belt[inPos]--
            robots.add(inPos)
            occupied[inPos] = true
        }

        //k개 확인하고 종료
        if(belt.count{ it == 0 } >= k)
            break
        cnt++
    }

    return cnt
}
