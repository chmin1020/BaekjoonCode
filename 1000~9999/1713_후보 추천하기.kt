data class Vote(val num: Int, val time: Int, var cnt: Int)

fun main() {
    //입력 받기
    val len = (readLine() ?: "0").toInt()
    readLine()
    val recArr = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    //갤러리 완성
    val gallery = mutableListOf<Vote>()
    recArr.forEachIndexed{i, new ->
        //이미 있는지 찾아내기 (있으면 삭제)
        val exist = gallery.find { it.num == new }
        gallery.removeIf{ it.num == new}

        if(gallery.size < len){ //갤러리에 사진 가득 차지 않음
            //이미 있으면 cnt 갱신, 없으면 전체 새로 만들기
            val newVote = exist?.also { it.cnt++ } ?: Vote(new, i, 1)
            gallery.add(newVote)
        }
        else { //사진 가득 참
            if(exist != null) //이미 있으면 cnt 갱신
                gallery.add(exist.also { it.cnt++ })
            else{ //없으면 최적 후보 지우고 새로 추가
                val minCnt = gallery.minByOrNull { it.cnt }?.cnt ?: 0
                gallery.filter { it.cnt == minCnt }.minByOrNull { it.time }?.let {
                    gallery.remove(it)
                }
                gallery.add(Vote(new, i, 1))
            }
        }
    }

    //출력
    gallery.sortedBy { it.num }.forEach{ print("${it.num} ") }
    println()
}
