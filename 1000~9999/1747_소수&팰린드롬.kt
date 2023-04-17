fun main(){
    //입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    //소수 거르기
    var answer = 1
    val isPrime = BooleanArray(2000000){ true }.also { it[0] = false; it[1] = false }
    for(num in 2 until 2000000){
        if(!isPrime[num]) continue
        if(!isPalindrome(num))
            isPrime[num] = false

        if(num >= n && isPrime[num]) {
            answer = num
            break
        }

        for(j in num * 2 until 2000000 step num)
            isPrime[j] = false
    }

    //출력
    with(System.out.bufferedWriter()){
        write("$answer\n")
        flush()
        close()
    }
}

//-- 숫자 회문 여부 판별 --//
fun isPalindrome(n: Int): Boolean{
    val tmp = mutableListOf<Int>()
    var num = n

    while (num != 0){
        tmp.add(num % 10)
        num /= 10
    }

    for(i in 0 until tmp.size / 2)
        if(tmp[i] != tmp[tmp.lastIndex - i])
            return false
    return true
}
