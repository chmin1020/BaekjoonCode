data class Match(val n1: Int, val n2: Int)

val friendMatches = mutableListOf<Match>()
val enemyMap = mutableMapOf<Int, MutableList<Int>>()
fun main(){
    //입력
    val n = (readLine()?:"").toInt()
    val m = (readLine()?:"").toInt()

    //enemy 맵 초기화
    for(i in 0 until n)
        enemyMap[i] = mutableListOf()

    //입력을 통해 각 정보를 그래프에 갱신
    for(i in 0 until m){
        val (relationShip, p, q) = (readLine()?:"").split(" ")

        when(relationShip[0]){
            'E' -> {
                enemyMap[p.toInt() - 1]?.add(q.toInt() - 1)
                enemyMap[q.toInt() - 1]?.add(p.toInt() - 1)
            }
            'F' -> {
                friendMatches.add(Match(p.toInt() - 1, q.toInt() - 1))
            }
        }
    }

    //각 원수의 원수끼리 친구관계를 맺기
    enemyMap.forEach{
        if(it.value.isNotEmpty()) {
            val leader = it.value.first()
            it.value.forEach { each ->
                if (leader != each)
                    friendMatches.add(Match(leader, each))
            }
        }
    }

    //유니온 파인드
    val teamIdx = IntArray(n)
    for(i in 0 until n)
        teamIdx[i] = i
    friendMatches.forEach { union(teamIdx, it) }

    //갱신 안된 것들 마무리
    for(i in 0 until n)
        find(teamIdx, i)

    //팀 개수 출력
    println(teamIdx.groupBy { it }.count())
}

//-- Union 함수 --//
fun union(teamIdx: IntArray, match: Match){
    val teamNum1 = find(teamIdx, match.n1)
    val teamNum2 = find(teamIdx, match.n2)

    //인덱스가 작은 것을 최종 부모로
    if(teamNum1 != teamNum2) {
        if(teamNum1 < teamNum2) teamIdx[teamNum2] = teamNum1
        else teamIdx[teamNum1] = teamNum2
    }
}

//-- Find 함수 --//
fun find(teamIdx: IntArray, man: Int): Int{
    if(teamIdx[man] == man)
        return man

    teamIdx[man] = find(teamIdx, teamIdx[man])
    return teamIdx[man]
}
