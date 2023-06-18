import java.math.BigInteger

fun main() {
    //입력
    val br = System.`in`.bufferedReader()
    val (num1, num2) = br.readLine().split(" ")

    val bigNum1 = BigInteger(num1)
    val bigNum2 = BigInteger(num2)

    val div = bigNum1.div(bigNum2)
    val rest = bigNum1.mod(bigNum2)

    //출력
    with(System.out.bufferedWriter()) {
        write("$div\n$rest\n")
        flush()
        close()
    }
}
