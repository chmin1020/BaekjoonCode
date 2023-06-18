fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()

    val arr = Array(cnt){""}
    repeat(cnt){ arr[it] = br.readLine() }

    //판별
    var answer = 0
    for(i in arr.indices){
        outer@for(j in i + 1 until cnt){
            val tmpMap = mutableMapOf<Char, Char>()

            val original = arr[i]
            val comp = arr[j]

            for(idx in original.indices){
                val rep = tmpMap[original[idx]]

                if(rep == null) tmpMap[original[idx]] = comp[idx]
                else if(rep != comp[idx]) //한 알파벳을 두 알파벳 이상으로
                    continue@outer
            }

            //제대로 알파벳 바꿈
            if (tmpMap.values.groupBy { it }.count() == original.groupBy { it }.count())
                answer++
        }
    }


    //출력
    with(System.out.bufferedWriter()) {
        write("$answer\n")
        flush()
        close()
    }
}
