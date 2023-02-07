class SegmentTree(len: Int){
    private val last = len
    private val tree = LongArray(len * 4){0}

    //-- 세그먼트 트리 검색 쿼리 함수 --//
    fun getSum(left: Int, right: Int, start: Int = 1, end: Int = last, idx: Int = 1): Long {
        //범위와 전혀 관련이 없음
        if (end < left || start > right)
            return 0

        //아예 범위 내에 포함됨
        if (start in left..right && end in left..right)
            return tree[idx]

        //둘 다 아니면 더 내부로 들어가보기
        val mid = (start + end) / 2
        return getSum(left, right, start, mid, idx * 2) + getSum(left, right, mid + 1, end, idx * 2 + 1)
    }

    //-- 세그먼트 트리 내용 갱신 함수 --//
    fun modifyValue(targetIdx: Int, newValue: Long, start: Int = 1, end: Int = last, idx: Int = 1): Long{
        //아예 관계가 없으면 0
        if(targetIdx < start || targetIdx > end)
            return 0

        //바꿀 인덱스면 값 변경하고 기존과의 차이값 리턴
        if(start == end && start == targetIdx){
            val diff = newValue - tree[idx]
            tree[idx] = newValue
            return diff
        }

        //둘 다 아니면 더 내부로 들어가보기
        val mid = (start + end) / 2
        val diff =
            (modifyValue(targetIdx, newValue, start, mid, idx * 2) + modifyValue(targetIdx, newValue, mid + 1, end, idx * 2 + 1))
        tree[idx] += diff

        return diff
    }
}

fun main(){
    //입력
    val (n, m) = (readLine()?:"").split(" ").map { it.toInt() }

    //sum 함수 결과 컬렉션
    val sumResults = mutableListOf<Long>()

    //명령어 받고 수행
    val segmentTree = SegmentTree(n)
    for(idx in 0 until m){
        val (order, param1, param2) = (readLine()?:"").split(" ").map { it.toInt() }

        //0이면 sum, 1이면 update
        when(order){
            0 -> {
                if(param1 <= param2) sumResults.add(segmentTree.getSum(left = param1, right = param2))
                else sumResults.add(segmentTree.getSum(left = param2, right = param1))
            }
            1 -> segmentTree.modifyValue(targetIdx = param1, newValue = param2.toLong())
        }
    }

    //출력
    println(sumResults.joinToString("\n"))
}
