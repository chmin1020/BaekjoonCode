import java.util.*

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    //맵 입력
    val map = Array(n){IntArray(n)}
    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        for(j in 0 until n)
            map[i][j] = st.nextToken().toInt()
    }

    var answer = 0
    for(i in map.indices){
        //가로 길
        if(wayCheck(map[i].asList(), l)) answer++

        //세로 길
        val way = mutableListOf<Int>()
        for(j in map.indices)
            way.add(map[j][i])

        if(wayCheck(way, l)) answer++
    }

    //출력
    println(answer)
    br.close()
}

fun wayCheck(way: List<Int>, l: Int): Boolean{
    var prevNode = way.first()
    var continuousCnt = 1

    //정주행
    var idx = 1
    while(idx in 1 until way.size){
        if(way[idx] == prevNode){
            continuousCnt++
            idx++
        }
        else{
            //오르막길, 길이 충분함
            if(way[idx] == prevNode + 1 && continuousCnt >= l){
                prevNode++
                continuousCnt = 1
                idx++
            }
            //내리막길
            else if(way[idx] == prevNode - 1){
                //연속 길이 체크
                if(idx + l > way.size) return false
                for(i in idx until idx + l)
                    if(way[i] != way[idx]) return false

                //충분하면 넘어가기
                idx = idx + l - 1
                prevNode--
                continuousCnt = -1 //중복 세기 방지
            }
            else
                return false
        }
    }
    return true
}
