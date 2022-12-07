import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //양수와 음수 구별하는 힙
        PriorityQueue<Integer> plusHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusHeap = new PriorityQueue<>(Collections.reverseOrder());

        //데이터를 받아 각자의 힙에 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());

            if(val > 0) plusHeap.add(val);
            else minusHeap.add(-val);
        }

        //절대값 최대의 크기가 가장 큰 힙 선택
        PriorityQueue<Integer> maxHeap;
        if(!plusHeap.isEmpty() && !minusHeap.isEmpty()){ //양수, 음수 다 있다
            if(plusHeap.peek() > minusHeap.peek())
                maxHeap = plusHeap;
            else
                maxHeap = minusHeap;
        }
        else if(plusHeap.isEmpty()) //음수만 있다
            maxHeap = minusHeap;
        else //양수만 있다
            maxHeap = plusHeap;

        //계산
        int answer = 0;
        if(!maxHeap.isEmpty())
            answer += maxHeap.poll();
        for(int i = 0; i < m - 1; i++)
            maxHeap.poll();

        while(!plusHeap.isEmpty()){
            answer += plusHeap.poll() * 2;
            for(int i = 0; i < m - 1; i++)
                plusHeap.poll();
        }
        while(!minusHeap.isEmpty()){
            answer += minusHeap.poll() * 2;
            for(int i = 0; i < m - 1; i++)
                minusHeap.poll();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
