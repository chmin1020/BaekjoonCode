import java.util.*

data class Condition(val a: Int, val b: Int, val c: Int)

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //입력
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    val answer = bfs(a, b, c, Condition(0, 0, c))

    //출력
    with(System.out.bufferedWriter()) {
        write("${answer.joinToString(" ")}\n")
        flush()
        close()
    }
}

//-- bfs 통한 경우의 수 계산 --//
fun bfs(a: Int, b: Int, c: Int, start: Condition): List<Int>{
    val redundantCheck = mutableSetOf(Condition(0, 0, c))
    val elements = mutableSetOf<Int>()

    val qu: Queue<Condition> = LinkedList()
    qu.add(start)

    //bfs
    while (qu.isNotEmpty()){
        val cur = qu.poll()

        if(cur.a == 0)
            elements.add(cur.c)

        //a -> b, a -> c
        val aToB = minOf(cur.a, b - cur.b)
        val aToC = minOf(cur.a, c - cur.c)
        queueInputTask(qu, redundantCheck, Condition(cur.a - aToB, cur.b + aToB, cur.c))
        queueInputTask(qu, redundantCheck, Condition(cur.a - aToC, cur.b, cur.c + aToC))

        //b -> a, b -> c
        val bToA = minOf(cur.b, a - cur.a)
        val bToC = minOf(cur.b, c - cur.c)
        queueInputTask(qu, redundantCheck, Condition(cur.a + bToA, cur.b - bToA, cur.c))
        queueInputTask(qu, redundantCheck, Condition(cur.a, cur.b - bToC, cur.c + bToC))

        //c -> a, c -> b
        val cToA = minOf(cur.c, a - cur.a)
        val cToB = minOf(cur.c, b - cur.b)
        queueInputTask(qu, redundantCheck, Condition(cur.a + cToA, cur.b, cur.c - cToA))
        queueInputTask(qu, redundantCheck, Condition(cur.a, cur.b + cToB, cur.c - cToB))
    }

    return elements.toList().sorted()
}

//-- 조건에 맞으면 큐 input 작업 수행 --//
fun queueInputTask(qu: Queue<Condition>, redundantCheck: MutableSet<Condition>, newCondition: Condition){
    if(!redundantCheck.contains(newCondition)){
        redundantCheck.add(newCondition)
        qu.add(newCondition)
    }
}
