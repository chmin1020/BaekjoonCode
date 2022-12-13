
//십의 자리 수의 암호화 가능성 여부 체크
fun isUsingTwoPossible(str: String): Boolean{
    return (str[0] != '0' && str.toInt() <= 26)
}

fun main(){
    //암호문 받기
    val cipher = readLine() ?: ""
    var answer = 0

    if(cipher.all { it.isDigit() }){ //암호문에 숫자만 있음
        val dp = IntArray(cipher.length + 1){0}
        dp[0] = 1

        //dp를 통한 array 채우기
        if(cipher[0] != '0') {
            dp[1] = 1
            for (i in 2..cipher.length) {
                val twoPossible = isUsingTwoPossible(cipher.substring(i - 2, i))

                if(cipher[i - 1] == '0'){ //0이면 앞이랑 조합이 가능해야만 유효
                    if(twoPossible)
                        dp[i] = dp[i - 2]
                    else
                        break
                }
                else{ //0이 아니면 조합 가능 여부에 따라 더하는 것 여부 달라짐
                    dp[i] = dp[i - 1]
                    if(twoPossible)
                        dp[i] += dp[i - 2]
                }
                dp[i] %= 1000000
            }
        }
        answer = dp[cipher.length]
    }
    println(answer)
}
