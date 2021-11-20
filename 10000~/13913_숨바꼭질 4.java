package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	private static final int LEN = 100001, NIL = -1;
	private static int[] before = new int[LEN];
	private static int[] time = new int[LEN];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Integer> qu = new LinkedList<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		int n, k, cur;
		
		Arrays.fill(before, NIL);
		Arrays.fill(time, NIL);
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		qu.add(n);
		time[n] = 0;
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
			
			if(cur - 1 >= 0 && time[cur - 1] == NIL) {
				before[cur - 1] = cur;
				time[cur - 1] = time[cur] + 1;
				if(cur - 1 == k) break;
				qu.add(cur - 1);
			}
			if(cur < k) {
				if(cur + 1 < LEN && time[cur + 1] == NIL) {
					before[cur + 1] = cur;
					time[cur + 1] = time[cur] + 1;
					if(cur + 1 == k) break;
					qu.add(cur + 1);
				}
				if(cur * 2 < LEN && time[cur * 2] == NIL) {
					before[cur * 2] = cur;
					time[cur * 2] = time[cur] + 1;
					if(cur * 2 == k) break;
					qu.add(cur * 2);
				}
			}
		}
		
		cur = k;
		bw.write(time[cur] + "\n");
		
		result.add(k);
		while(before[cur] != NIL) {
			cur = before[cur];
			result.add(cur);
		}
		
		while(!result.isEmpty()) {
			bw.write(result.pop() + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
