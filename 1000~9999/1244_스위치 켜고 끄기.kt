fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val size = br.readLine().toInt()
    val switches = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    repeat(br.readLine().toInt()){
        val (gender, num) = br.readLine().split(" ").map { it.toInt() }

        when(gender){
            1 -> { //남자
                var cur = num
                while(cur <= size){
                    switches[cur - 1] = 1 - switches[cur - 1]
                    cur += num
                }
            }
            2 -> { //여자
                switches[num - 1] = 1 - switches[num - 1]
                var diff = 1
                while (num - 1 - diff >= 0 && num -1 + diff < size){
                    if(switches[num - 1 - diff] == switches[num - 1 + diff]){
                        switches[num - 1 - diff] = 1 - switches[num - 1 - diff]
                        switches[num - 1 + diff] = 1 - switches[num - 1 + diff]
                    }
                    else break
                    diff++
                }
            }
        }
    }

    //출력
    with(System.out.bufferedWriter()) {
        for(i in switches.indices){
            write("${switches[i]}")
            write(if(i % 20 == 19) "\n" else " ")
        }
        flush()
        close()
    }
}
