
// 피보나치 구하는 배열과 함수
val fibonacci = IntArray(32){1}
fun getFibonacci(n: Int) : Int{
    if(n == 1 || n == 2) return 1

    if(fibonacci[n] == 1)
        fibonacci[n] = getFibonacci(n - 1) + getFibonacci(n - 2)
    return fibonacci[n]
}

//브루트포스로 찾기
fun getAnswer(day: Int, target: Int){
    val forFirst = fibonacci[day - 2]
    val forSecond = fibonacci[day - 1]
    var first = 0

    while(true){
        first++
        if((target - forFirst * first) % forSecond != 0)
            continue
        val second = (target - forFirst * first) / forSecond

        print("$first\n$second")
        break
    }
}


fun main() {
    //입력 받기
    val dayAndNum = (readLine() ?: "0").split(" ").map{ it.toInt() }.toIntArray()

    getFibonacci(dayAndNum[0])
    getAnswer(dayAndNum[0], dayAndNum[1])
}
