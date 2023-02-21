import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()

    //테스트 케이스 반복
    val answers = mutableListOf<Int>()
    for (i in 0 until tc) {
        //각 케이스의 입력 과정
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val aGroup = IntArray(n)
        val bGroup = IntArray(m)

        st = StringTokenizer(br.readLine())
        for (j in 0 until n)
            aGroup[j] = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        for (j in 0 until m)
            bGroup[j] = st.nextToken().toInt()

        //정렬
        aGroup.sort()
        bGroup.sort()

        //num -> 정렬된 순서로 나옴, 따라서 시작점을 계속 줄여갈 수 있다
        var sum = 0
        var start = 0
        for (num in aGroup) {
            if(bGroup.last() < num) //더 이상 큰 경우가 없다
                sum += m
            else { //작은 것들 개수 구하기
                start = lowerBound(bGroup, num, start, m - 1)
                sum += start
            }
        }

        answers.add(sum)
    }

    //각각 판별 후 출력
    println(answers.joinToString("\n"))
    br.close()
}

//-- 이진탐색을 활용한 lower bound 탐색 --//
fun lowerBound(arr: IntArray, target: Int, start: Int, end: Int): Int {
    var left = start
    var right = end

    //하향선 탐색
    while(left < right){
        val mid = (left + right) / 2

        //크거나 같은 것은 하향선의 후보가 된다
        if(arr[mid] >= target) right = mid
        else left = mid + 1
    }

    return right
}
