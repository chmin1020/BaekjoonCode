import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //수열 입력
    val n = br.readLine().toInt()
    val arr = IntArray(n)
    val st = StringTokenizer(br.readLine())
    for(i in 0 until n)
        arr[i] = st.nextToken().toInt()
    val (start, end) = br.readLine().split(" ").map { it.toInt() - 1 }

    //답 구하기
    val answer = getAnswer(arr, start, end)

    //출력
    with(System.out.bufferedWriter()){
        write("$answer\n")
        flush()
        close()
    }
}

val cases = intArrayOf(-1, 1)

//-- bfs로 계산 --//
fun getAnswer(arr: IntArray, start: Int, end: Int): Int{
    val situation = BooleanArray(arr.size){ false }
    val qu:Queue<Pair<Int, Int>> = LinkedList()

    qu.add(Pair(start, 0))
    situation[start] = true

    //(위치, 횟수)
    while (qu.isNotEmpty()){
        val cur = qu.poll()
        val interval = arr[cur.first]

        if(cur.first == end)
            return cur.second

        var mul = interval
        while (true){
            var moreWay = false

            //양 옆 이동 시도
            for(d in 0 until 2){
                val newPos = cur.first + (mul * cases[d])

                if(newPos in arr.indices){
                    moreWay = true //더 갈 수 있음

                    //한 번도 안 가봄
                    if(!situation[newPos]) {
                        situation[newPos] = true
                        qu.add(Pair(newPos, cur.second + 1))
                    }
                }
            }

            if(!moreWay) //더 이상 이동이 안됨
                break
            mul += interval
        }
    }

    return -1
}
