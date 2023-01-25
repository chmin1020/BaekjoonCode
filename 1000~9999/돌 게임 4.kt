fun main() {
    //입력
    val n = (readLine() ?: "0").toInt()

    val winner = Array(1001){""}
    winner.let {
        it[0] = "SK"
        it[1] = "CY"
        it[2] = "SK"
        it[3] = "CY"
    }

    for(i in 4 .. n){
        if(winner[i - 1] == "CY" || winner[i - 3] == "CY" || winner[i - 4] == "CY")
            winner[i] = "SK"
        else
            winner[i] = "CY"
    }

    //출력
    println(winner[n])
}
