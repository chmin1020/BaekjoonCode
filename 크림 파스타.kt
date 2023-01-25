fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()
    val arr = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //각 구간에서의 빼기 가능한 최솟값
    val possibleMin = IntArray(n){0}.also { it[0] = arr[0]}
    for(i in 1 until n)
        possibleMin[i] = minOf(arr[i], possibleMin[i - 1])

    //출력
    var bestSoFar = 0
    for(i in possibleMin.indices){
        bestSoFar = maxOf(bestSoFar, arr[i] - possibleMin[i])
        print("$bestSoFar ")
    }
    println()
}
