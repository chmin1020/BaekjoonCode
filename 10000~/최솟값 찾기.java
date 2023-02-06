import java.io.*;
import java.util.*;

public class Main{
    private static class Info{
        int value, idx;

        Info(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        //출력 도구
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //과정 컬렉션
        Deque<Info> deque = new ArrayDeque<Info>();

        //각 구간 최솟값 찾기
        st = new StringTokenizer(br.readLine());
        for(int end = 0; end < n; end++){
            int newVal = Integer.parseInt(st.nextToken());

            //필요없는 중간값 제외하기
            while (!deque.isEmpty() && deque.peekLast().value > newVal)
                deque.pollLast();

            //새 값 추가
            deque.offerLast(new Info(newVal, end));

            //앞의 값 뺄지 결정
            if(deque.peekFirst().idx < (end - l + 1))
                deque.pollFirst();

            //출력
            if(!deque.isEmpty())
                bw.write(deque.peekFirst().value + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
