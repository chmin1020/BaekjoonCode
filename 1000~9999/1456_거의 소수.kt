const val LIMIT = 10000000

fun main() {
    //입력
    val (lowLimit, highLimit) = (readLine() ?: "0 0").split(" ").map { it.toLong() }

    //체로 소수 리스트 완성
    val isPrimeArr = BooleanArray(LIMIT + 1){true}
    val primes = mutableListOf<Int>()
    for(i in 2..LIMIT){
        if(!isPrimeArr[i]) continue
        else primes.add(i)

        for(j in i * 2..LIMIT step(i))
            isPrimeArr[j] = false
    }

    //각 소수마다 범위 내 숫자 체크
    var answer = 0L
    primes.forEach {
        var test = it.toLong() * it.toLong()
        while(test <= highLimit){
            if(test >= lowLimit)
                answer++
            
            //long 범위까지 넘어서는 것 방지
            if(Long.MAX_VALUE / it <= test) break
            else test *= it.toLong()
        }
    }

    //출력
    println(answer)
}
