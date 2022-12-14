fun main() {
    //입력 받기
    val str = (readLine() ?: "")

    val len = str.length
    var answer = 0
    for (i in 0 until len)
        answer = maxOf(answer, getMax(str.substring(i, len)))
    println(answer)
}

// 문자열 s에서 최대 부분 문자열의 길이 반환 (kmp 응용)
fun getMax(s: String): Int {
    var j = 0
    val len = s.length
    var max = 0

    val pi = IntArray(len){0}

    for (i in 1 until len) {
        while (j > 0 && s[i] != s[j])
            j = pi[j - 1]

        // 같은 부분 증가
        if (s[i] == s[j]) {
            pi[i] = ++j
            max = maxOf(max, pi[i])
        }
    }
    return max
}
