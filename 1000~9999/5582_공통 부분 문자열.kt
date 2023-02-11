fun main(){
    //입력
    val br = System.`in`.bufferedReader()

    val str1 = br.readLine()
    val str2 = br.readLine()

    //dp 접근
    val dp = Array(str1.length + 1){IntArray(str2.length + 1){0} }

    var answer = 0
    for(i in str1.indices){
        for(j in str2.indices){
            if(str1[i] == str2[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
                answer = maxOf(answer, dp[i + 1][j + 1])
            }
        }
    }

    //출력
    println(answer)

    br.close()
}
