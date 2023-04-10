import java.util.*

fun main() {
    //세팅
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    //입력
    val n = br.readLine().toInt()
    val arr = IntArray(n)
    repeat(n){ arr[it] = br.readLine().toInt() - 1 }

    //사이클 찾기
    val visited = BooleanArray(n){false}
    for(idx in arr.indices){
        if(visited[idx]) continue

        val st = Stack<Int>()
        st.push(idx)
        visited[idx] = true

        while (st.isNotEmpty()){
            val newVal = arr[st.peek()]
            if(visited[newVal]){
                while (st.isNotEmpty()) //사이클이면 다 true 유지하고 아니면 false 돌림
                    visited[st.pop()] = (newVal == idx)
            }
            else {
                visited[newVal] = true
                st.push(newVal)
            }
        }
    }

    //출력
    bw.write("${visited.count{ it }}\n")
    for(idx in visited.indices)
        if(visited[idx])
            bw.write("${idx + 1}\n")
    bw.flush()
    bw.close()
}
