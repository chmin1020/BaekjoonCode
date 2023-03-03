import java.util.*

const val NO_PARTNER = -1
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //남자 입력
    val males = Array(n){ IntArray(n) }
    val malePartner = IntArray(n){ NO_PARTNER }
    for(idx in males.indices)
        males[idx] = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()

    //여자 입력
    val femalePartner = IntArray(n){ NO_PARTNER }
    val maleRankFind = Array(n){ IntArray(n)}
    for(idx in 0 until n) {
        val preferences = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
        for(i in 0 until n)
            maleRankFind[idx][preferences[i]] = i
    }

    br.close()

    //총각 설정
    val bachelors: Queue<Int> = LinkedList()
    for(i in 0 until n)
        bachelors.add(i)

    //-- 결혼 매크로 --//
    fun marry(male: Int, female: Int){
        malePartner[male] = female
        femalePartner[female] = male
    }

    //-- 이혼당함 매크로 --//
    fun divorced(poolMale: Int){
        malePartner[poolMale] = NO_PARTNER
        bachelors.add(poolMale)
    }

    //결혼 결정 순환
    while (bachelors.isNotEmpty()){
        val cur = bachelors.poll()

        //결혼 상대 물색
        for(candidate in males[cur]){
            if(femalePartner[candidate] == NO_PARTNER){
                //여자도 짝이 없으면 결혼
                marry(cur, candidate)
                break
            }
            else{
                //여자 입장에서 짝 비교
                val currentMaleRank = maleRankFind[candidate][femalePartner[candidate]]
                val newMaleRank = maleRankFind[candidate][cur]

                //지금 남자가 더 매력적이면 이혼 및 재혼
                if(currentMaleRank > newMaleRank){
                    divorced(femalePartner[candidate])
                    marry(cur, candidate)
                    break
                }
            }
        }
    }

    //출력
    for(i in 0 until n)
        println(malePartner[i] + 1)
}
