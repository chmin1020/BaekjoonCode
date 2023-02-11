import java.util.*

fun main(){
    //입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    //그래프 받기
    val graph = Array(n + 1){ mutableListOf<Int>()}
    val cost = IntArray(n + 1)
    val completed = BooleanArray(n + 1){false}
    val nextBuildingIds = mutableMapOf<Int, MutableList<Int>>()

    for(i in 1 .. n){
        val st = StringTokenizer(br.readLine())

        //코스트와 필요 건물 분리
        cost[i] = st.nextToken().toInt()
        while(st.hasMoreTokens()){
            val id = st.nextToken().toInt()
            graph[i].add(id)

            if(nextBuildingIds[id].isNullOrEmpty())
                nextBuildingIds[id] = mutableListOf()

            nextBuildingIds[id]?.add(i)
        }
        graph[i].removeLast() //-1은 제외
    }

    //위상 정렬
    val answer = IntArray(n + 1){ 0 }
    var complete = 0
    while(complete <= n){
        graph.forEachIndexed{idx, it ->
            //건설이 되지 않았고 현재 가능한 상태
            if(!completed[idx] && it.isEmpty()){
                //기본 필요 소요 시간에 제작시간 더한게 답
                answer[idx] += cost[idx]

                //연관 건물 연산 처리
                nextBuildingIds[idx]?.forEach { id->
                    graph[id].remove(idx)
                    answer[id] = maxOf(answer[id], answer[idx])
                }

                //건설 완료
                completed[idx] = true
                complete++
            }
        }
    }

    //출력
    for(i in 1 until answer.size)
        println(answer[i])
    br.close()
}
