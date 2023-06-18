import java.util.PriorityQueue

//-- 팀 정보 데이터 클래스 --//
data class TeamInfo(val name: String, val score: Int): Comparable<TeamInfo>{
    override fun compareTo(other: TeamInfo): Int {
        return if(other.score == this.score)
            this.name.compareTo(other.name)
        else
            other.score - this.score
    }
}

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val heap = PriorityQueue<TeamInfo>()
    val name = br.readLine()
    val cnt = br.readLine().toInt()

    //각 팀 이름 받아서 계산
    repeat(cnt){
        val teamName = br.readLine()
        val L = name.count { it == 'L' } + teamName.count{ it == 'L' }
        val O = name.count { it == 'O' } + teamName.count{ it == 'O' }
        val V = name.count { it == 'V' } + teamName.count{ it == 'V' }
        val E = name.count { it == 'E' } + teamName.count{ it == 'E' }

        val score: Long =((L + O).toLong() * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100
        heap.add(TeamInfo(teamName, score.toInt()))
    }

    //출력
    with(System.out.bufferedWriter()) {
        write("${heap.poll().name}\n")
        flush()
        close()
    }
}
