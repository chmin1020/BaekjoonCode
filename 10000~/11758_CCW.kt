fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val poses = Array(3){ IntArray(2) }
    repeat(3){ idx ->
        poses[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    //답 구하기
    val decision = getAnswer(poses)

    //출력
    with(System.out.bufferedWriter()){
        write("$decision\n")
        flush()
        close()
    }
}

//-- 정답 구하기 --//
fun getAnswer(poses: Array<IntArray>): Int {
    val a = poses[0][0] * poses[1][1] + poses[1][0] * poses[2][1] + poses[2][0] * poses[0][1]
    val b = poses[0][1] * poses[1][0] + poses[1][1] * poses[2][0] + poses[2][1] * poses[0][0]

    return when{
        a - b > 0 -> 1
        a - b < 0 -> -1
        else -> 0
    }
}
