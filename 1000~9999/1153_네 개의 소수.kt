fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //상수까지의 소수 구하기
    val primes = mutableSetOf<Int>()
    val checkChe = BooleanArray(n + 1)
    for(i in 2..n){
        if(checkChe[i]) continue
        primes.add(i)

        for(j in i * 2 .. n step(i))
            checkChe[j] = true
    }

    //연산 및 출력
    println(getFourMemberPrimes(primes, n).joinToString(" "))
}

//-- 4개의 부분 소수 구하기 --//
fun getFourMemberPrimes(primes: Set<Int>, n: Int): List<Int> {
    val res = mutableListOf<Int>()

    if(n < 8)
        res.add(-1)
    else if(n % 2 == 0){
        res.add(2)
        res.add(2)

        for(i in 2 until n - 4){
            if(primes.contains(i) && primes.contains(n - 4 - i)){
                res.add(i)
                res.add(n - 4 - i)
                break
            }
        }
    }
    else{
        res.add(2)
        res.add(3)

        for(i in 2 until n - 5){
            if(primes.contains(i) && primes.contains(n - 5 - i)){
                res.add(i)
                res.add(n - 5 - i)
                break
            }
        }
    }

    return res
}
