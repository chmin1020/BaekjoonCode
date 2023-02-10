import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val NOT_DECIDED = 0
const val DECIDING = -1
const val NO_TEAM = -2

fun main(){
    //입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()

    //답 컬렉션
    val answers = mutableListOf<Int>()

    //각 케이스 돌리기
    for(i in 0 until tc){
        //케이스 입력
        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())

        val arr = IntArray(n + 1)
        for(each in 1 .. n)
            arr[each] = st.nextToken().toInt()

        //케이스에 맞는 답 추가
        answers.add(getTeamCount(arr))
    }

    //출력
    println(answers.joinToString("\n"))
}


fun getTeamCount(points: IntArray): Int{
    val team = IntArray(points.size){ NOT_DECIDED }

    //팀이 안 정해진 녀석 팀 형성 시도
    for(i in 1 until points.size) {
        if (team[i] == NOT_DECIDED) {
            team[i] = DECIDING
            checkProperTeam(points, team, mutableListOf(i))
        }
    }

    //팀이 확실히 안 생긴 녀석 세기
    return team.filter { it <= 0 }.count() - 1
}

//-- dfs 탐색 함수 --//
fun checkProperTeam(points: IntArray, team: IntArray, teamCandidates: MutableList<Int>){
    val newTeamMate = points[teamCandidates.last()]

    //이미 팀 여부가 결정되어 있다 -> 새로운 팀 불가
    if(team[newTeamMate] > 0 || team[newTeamMate] == NO_TEAM)
        return

    //팀에 포함된 녀석
    if(team[newTeamMate] == DECIDING){
        //팀 적용하고 종료
        var teamNumber = NO_TEAM
        for(candidate in teamCandidates){
            //팀 내부 사이클 형성이 있다면 걔네들은 팀
            if(candidate == newTeamMate)
                teamNumber = newTeamMate

            team[candidate] = teamNumber
        }
        return
    }

    //새 후보 녀석 평가
    team[newTeamMate] = DECIDING
    teamCandidates.add(newTeamMate)
    checkProperTeam(points, team, teamCandidates)
}
