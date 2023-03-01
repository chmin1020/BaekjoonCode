
var answer = 2
fun main() {
    //입력 세팅
    val br = System.`in`.bufferedReader()

    //상수 입력
    val len = br.readLine().toInt()

    //보드 입력
    val board = Array(len) { IntArray(len) }
    for (idx in board.indices)
        board[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    //보드 이동 시뮬 돌리기
    moveBoard(board, len,1)

    //출력
    println(answer)
    br.close()
}

//-- 보드 이동 시뮬레이션 총괄 --//
fun moveBoard(board: Array<IntArray>, len: Int, cnt: Int){
    if(cnt > 5) return

    for(i in 0 until 4){
        //원본을 훼손하지 않도록 복사본 생성
        val copy = getCopyBoard(board, len)

        //4가지 방향 이동
        when(i){
            0 -> toUp(copy, len)
            1 -> toDown(copy, len)
            2 -> toLeft(copy, len)
            3 -> toRight(copy, len)
        }

        //최고 숫자 확인
        for(row in 0 until len)
            for(col in 0 until len)
                answer = maxOf(answer, copy[row][col])

        //더 이동해보기
        moveBoard(copy, len, cnt + 1)
    }
}

//-- 위쪽으로 이동한 결과 --//
fun toUp(board: Array<IntArray>, len: Int){
    for(col in 0 until len){
        //숫자끼리 붙이기
        var pos = 0
        for(row in 0 until len){
            if(board[row][col] != 0){
                board[pos][col] = board[row][col]

                if(pos != row) board[row][col] = 0
                pos++
            }
        }

        //가능한 수 합치기
        for(row in 1 until len){
            if(board[row - 1][col] == board[row][col]){
                board[row - 1][col] *= 2
                board[row][col] = 0
            }
        }

        //숫자끼리 붙이기
        pos = 0
        for(row in 0 until len){
            if(board[row][col] != 0){
                board[pos][col] = board[row][col]

                if(pos != row) board[row][col] = 0
                pos++
            }
        }
    }
}

//-- 아래쪽으로 이동한 결과 --//
fun toDown(board: Array<IntArray>, len: Int){
    for(col in 0 until len){
        //숫자끼리 붙이기
        var pos = len - 1
        for(row in len - 1 downTo 0){
            if(board[row][col] != 0){
                board[pos][col] = board[row][col]

                if(pos != row) board[row][col] = 0
                pos--
            }
        }

        //가능한 수 합치기
        for(row in len - 2 downTo 0){
            if(board[row + 1][col] == board[row][col]){
                board[row + 1][col] *= 2
                board[row][col] = 0
            }
        }

        //숫자끼리 붙이기
        pos = len - 1
        for(row in len - 1 downTo 0){
            if(board[row][col] != 0){
                board[pos][col] = board[row][col]

                if(pos != row) board[row][col] = 0
                pos--
            }
        }
    }
}

//-- 왼쪽으로 이동한 결과 --//
fun toLeft(board: Array<IntArray>, len: Int){
    for(row in 0 until len){
        //숫자끼리 붙이기
        var pos = 0
        for(col in 0 until len){
            if(board[row][col] != 0){
                board[row][pos] = board[row][col]

                if(pos != col) board[row][col] = 0
                pos++
            }
        }

        //가능한 수 합치기
        for(col in 1 until len){
            if(board[row][col - 1] == board[row][col]){
                board[row][col - 1] *= 2
                board[row][col] = 0
            }
        }

        //숫자끼리 붙이기
        pos = 0
        for(col in 0 until len){
            if(board[row][col] != 0){
                board[row][pos] = board[row][col]

                if(pos != col) board[row][col] = 0
                pos++
            }
        }
    }
}

//-- 오른쪽으로 이동한 결과 --//
fun toRight(board: Array<IntArray>, len: Int){
    for(row in 0 until len){
        //숫자끼리 붙이기
        var pos = len - 1
        for(col in len - 1 downTo 0){
            if(board[row][col] != 0){
                board[row][pos] = board[row][col]

                if(pos != col) board[row][col] = 0
                pos--
            }
        }

        //가능한 수 합치기
        for(col in len - 2 downTo 0){
            if(board[row][col + 1] == board[row][col]){
                board[row][col + 1] *= 2
                board[row][col] = 0
            }
        }

        //숫자끼리 붙이기
        pos = len - 1
        for(col in len - 1 downTo 0){
            if(board[row][col] != 0){
                board[row][pos] = board[row][col]

                if(pos != col) board[row][col] = 0
                pos--
            }
        }
    }
}

//-- 복사한 보드를 가져오는 함수 --//
fun getCopyBoard(board: Array<IntArray>, len: Int): Array<IntArray>{
    val copyBoard = Array(len) { IntArray(len) }
    for (i in 0 until len)
        for (j in 0 until len)
            copyBoard[i][j] = board[i][j]

    return copyBoard
}
