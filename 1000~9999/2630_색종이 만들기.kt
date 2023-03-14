
var whiteCnt = 0
var blueCnt = 0

fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val n = br.readLine().toInt()

    //종이 입력
    val papers = Array(n){IntArray(n)}
    repeat(n){
        papers[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    //작업 수행
    divideAndCheckPaper(papers, 0, 0, n)

    //출력
    println("$whiteCnt\n$blueCnt")
}

//-- 색종이에 대한 divide and conquer --//
fun divideAndCheckPaper(papers: Array<IntArray>, sx: Int, sy: Int, size: Int){
    val color = papers[sx][sy]

    //종이 더 이상 못 나눈다
    if(size == 1){
        increaseCount(color)
        return
    }

    //같은 색 체크
    var isOnePaper = true
    outer@for(x in sx until sx + size){
        for(y in sy until sy + size){
            if(color != papers[x][y]){
                isOnePaper = false
                break@outer
            }
        }
    }

    //결정
    if(isOnePaper)
        increaseCount(color)
    else{
        val nextSize = size /2
        divideAndCheckPaper(papers, sx, sy, nextSize)
        divideAndCheckPaper(papers, sx + nextSize, sy, nextSize)
        divideAndCheckPaper(papers, sx, sy + nextSize, nextSize)
        divideAndCheckPaper(papers, sx + nextSize, sy + nextSize, nextSize)
    }
}

//-- 색 카운트 올리기 --//
fun increaseCount(color: Int){
    when(color){
        0 -> whiteCnt++
        1 -> blueCnt++
    }
}
