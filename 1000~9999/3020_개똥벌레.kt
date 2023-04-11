fun main() {
    //세팅
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val downs = mutableListOf<Int>()
    val ups = mutableListOf<Int>()

    //입력
    val (n, h) = br.readLine().split(" ").map { it.toInt() }
    repeat(n){
        if(it % 2 == 0) downs.add(br.readLine().toInt())
        else ups.add(br.readLine().toInt())
    }

    //정렬
    val sortedDowns = downs.sorted().toIntArray()
    val sortedUps = ups.sorted().toIntArray()

    var minObstacleCnt = n
    var minSpaceCnt = 0
    for(height in 1 .. h){
        val downEncounters = sortedDowns.size - obstacleBinarySearch(sortedDowns, height)
        val upEncounters = sortedUps.size - obstacleBinarySearch(sortedUps, h - height + 1)
        
        //장애물 수 같은 공간
        if(downEncounters + upEncounters == minObstacleCnt)
            minSpaceCnt++

        //더 적은 장애물 수 발견
        if(downEncounters + upEncounters < minObstacleCnt){
            minObstacleCnt = downEncounters + upEncounters
            minSpaceCnt = 1
        }
    }

    bw.write("$minObstacleCnt $minSpaceCnt\n")
    bw.flush()
    bw.close()
}

//-- 이진 탐색으로 처음 충돌하는 장애물 인덱스 구하기 --//
fun obstacleBinarySearch(arr: IntArray, target: Int): Int{
    var start = 0
    var end = arr.lastIndex
    var answer = arr.size

    //lower bound
    while (start <= end){
        val mid = (start + end) / 2

        if(arr[mid] < target)
            start = mid + 1
        else{
            answer = mid
            end = mid - 1
        }
    }
    return answer
}
