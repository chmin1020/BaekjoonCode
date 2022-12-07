import kotlin.math.pow

val factDp = LongArray(19){0}
val primes = intArrayOf(2,3,5,7,11,13,17)

fun main(){
    val aPer = readLine()?.toDouble()?.div(100) ?: 1.0
    val bPer = readLine()?.toDouble()?.div(100) ?: 1.0

    var aTotalPer = 0.0
    var bTotalPer = 0.0

    primes.forEach {
        val aGoalPer = aPer.pow(it.toDouble())
        val aNotGoalPer = (1.0 - aPer).pow(18 - it.toDouble())
        val bGoalPer = bPer.pow(it.toDouble())
        val bNotGoalPer = (1.0 - bPer).pow(18 - it.toDouble())

        aTotalPer += (combinationForSoccer(it).toDouble() * aGoalPer * aNotGoalPer)
        bTotalPer += (combinationForSoccer(it).toDouble() * bGoalPer * bNotGoalPer)
    }
    println(aTotalPer + bTotalPer - (aTotalPer * bTotalPer))
}

fun combinationForSoccer(r: Int): Long{
    return factorial(18) / (factorial(18 - r) * factorial(r))
}

fun factorial(i: Int): Long{
    if(i == 0)
        return 1

    if(factDp[i] == 0L)
        factDp[i] = i * factorial(i - 1)

    return factDp[i]
}
