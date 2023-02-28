import java.util.*

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val (n1, n2) = br.readLine().split(" ").map { it.toInt() }

    //출력
    println(getReverseNum(getReverseNum(n1) + getReverseNum(n2)))
    br.close()
}

fun getReverseNum(num: Int): Int{
    val st = Stack<Int>()

    var tmp = num
    while(tmp != 0){
        st.add(tmp % 10)
        tmp /= 10
    }

    var res = 0
    var mult = 1
    while(st.isNotEmpty()){
        res += (st.pop() * mult)
        mult *= 10
    }

    return res
}
