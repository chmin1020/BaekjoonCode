fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (_, l) = br.readLine().split(" ").map { it.toInt() }

    //위치 입력
    val locations = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    locations.sort()
    br.close()

    //그리디하게 구하기
    var answer = 1
    var start = locations[0]
    for(each in locations){
        if(each - start >= l){
            answer++
            start = each
        }
    }

    //출력
    println(answer)
}
