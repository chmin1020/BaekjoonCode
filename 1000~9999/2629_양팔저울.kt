import kotlin.math.abs

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //추 입력
    br.readLine().toInt()
    val weights = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    //구슬 입력
    br.readLine().toInt()
    val beads =  br.readLine().split(" ").map { it.toInt() }

    //각 연산으로 답 생성
    val maxWeight = maxOf(beads.maxByOrNull { it } ?: beads[0], weights.sum())
    val possibleSet = makePossibleWeightSet(weights, maxWeight)
    val answers = mutableListOf<Char>()
    beads.forEach {
        answers.add(if(possibleSet.contains(it)) 'Y' else 'N')
    }

    //출력
    println(answers.joinToString(" "))
}

//-- 추로 표현이 가능한 구슬(무게) 구하기 --//
fun makePossibleWeightSet(weights: IntArray, maxWeight: Int): Set<Int>{
    val result = mutableSetOf<Int>().also { it.addAll(weights.toList()) }

    //가로가 가능 구슬 무게, 세로가 각 추 무게
    val dp = Array(weights.size){ BooleanArray(maxWeight + 1) }
    weightSimulation(result, dp, weights, -1, 0)

    return result
}

//-- dp 계산에서 현재 무게가 가능한 무게인지 판별 --//
fun weightSimulation(set: MutableSet<Int>, dp: Array<BooleanArray>, weights: IntArray, idx: Int, cur: Int) {
    if(cur !in dp[0].indices || (idx >= 0 && dp[idx][cur])) return

    set.add(cur)
    if(idx in dp.indices) dp[idx][cur] = true

    if(idx == weights.lastIndex)
        return

    weightSimulation(set, dp, weights, idx + 1, cur) //안 올림
    weightSimulation(set, dp, weights, idx + 1, abs(cur - weights[idx + 1])) //구슬 쪽에
    weightSimulation(set, dp, weights, idx + 1, cur + weights[idx + 1]) //추 쪽에
}
