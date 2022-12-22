fun main() {
   //해답 함수
   fun solution(first: Long, second: Long){
       //숫자 정렬
       var bigA = if(first > second) first else second
       var bigB = if(first > second) second else first

       //호제법 계산
       var rest:Long
       do{
            rest = bigA %bigB
            bigA = bigB
            bigB = rest
        }while(bigB != 0L)

        println("1".repeat(bigA.toInt()))
   }

    //입력 및 함수 실행
    val twos = (readLine() ?: "0 0").split(" ").map { it.toLong() }
    solution(twos[0], twos[1])
}
