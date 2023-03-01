fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()
    br.readLine()

    //집합 입력
    val set1 = br.readLine().split(" ").map { it.toInt() }.toMutableSet()
    val set2 = br.readLine().split(" ").map { it.toInt() }.toMutableSet()

    //서로 차집합으로 만들기
    val tmpSet = mutableSetOf<Int>().also { it.addAll(set1) }
    set2.forEach { set1.remove(it) }
    tmpSet.forEach { set2.remove(it) }

    //출력
    println(set1.size + set2.size)
    br.close()
}
