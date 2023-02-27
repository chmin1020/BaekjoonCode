import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }

    //출력
    val wayCnt = findWay(f, s, g, u, d)
    println(if(wayCnt == -1) "use the stairs" else wayCnt)
    br.close()
}

//-- bfs 통한 필요 횟수 계산 --//
fun findWay(f: Int, s: Int, g: Int, u: Int, d: Int): Int{
    val wayCnt = IntArray(f + 1){ -1 }
    val qu:Queue<Int> = LinkedList()
    qu.add(s)
    wayCnt[s] = 0

    val go = intArrayOf(u, -d)
    while (qu.isNotEmpty()){
        val cur = qu.poll()

        //도착했으면 탐색 불필요
        if(cur == g)
            break

        //위층, 아래층
        for(method in go){
            val dest = cur + method

            if(dest in 1 .. f && wayCnt[dest] == -1){
                wayCnt[dest] = wayCnt[cur] + 1
                qu.add(dest)
            }
        }
    }
    return wayCnt[g]
}
