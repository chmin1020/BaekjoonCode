
// 피보나치 구하는 배열과 함수
val fibonacci = IntArray(100){-1}
fun getFibonacci(n: Int) : Int{
    if(n <= 1) return 1
    if(n == 2) return 2

    if(fibonacci[n] == -1)
        fibonacci[n] = getFibonacci(n - 1) + getFibonacci(n - 2)
    return fibonacci[n]
}

fun main() {
    //입력 받기
    val n = (readLine() ?: "1").toInt()
    val m = (readLine() ?: "0").toInt()

    //vip 좌석 기점으로 나뉜 연속 좌석 설정
    var start = 1
    val spaces = IntArray(m + 1)
    for(i in 0 until m){
        val end = (readLine() ?: "0").toInt()
        spaces[i] = end - start
        start = end + 1
    }
    spaces[m] = n - start + 1

    //곱해서 답 구하기
    var answer = 1
    spaces.forEach { answer *= getFibonacci(it) }
    print(answer)
}
// 피보나치 구하는 배열과 함수
val fibonacci = IntArray(100){-1}
fun getFibonacci(n: Int) : Int{
    if(n <= 1) return 1
    if(n == 2) return 2

    if(fibonacci[n] == -1)
        fibonacci[n] = getFibonacci(n - 1) + getFibonacci(n - 2)
    return fibonacci[n]
}

fun main() {
    //입력 받기
    val n = (readLine() ?: "1").toInt()
    val m = (readLine() ?: "0").toInt()

    //vip 좌석 기점으로 나뉜 연속 좌석 설정
    var start = 1
    val spaces = IntArray(m + 1)
    for(i in 0 until m){
        val end = (readLine() ?: "0").toInt()
        spaces[i] = end - start
        start = end + 1
    }
    spaces[m] = n - start + 1

    //곱해서 답 구하기
    var answer = 1
    spaces.forEach { answer *= getFibonacci(it) }
    print(answer)
}
