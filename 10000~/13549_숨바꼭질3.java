package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	private static final int LEN = 100001;
	private static final int INF = 50000000;
	private static int[] dis = new int[LEN];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Integer> qu = new LinkedList<Integer>();
		int n, k, cur;
		
		Arrays.fill(dis, INF);
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		qu.add(n);
		dis[n] = 0;
		while(!qu.isEmpty()) {
			cur = qu.pollFirst();
			if(cur == k) {
				bw.write(dis[cur] + "\n");
				break;
			}
				
			if(cur * 2 < LEN && dis[cur * 2] > dis[cur]) {	
				dis[cur * 2] = dis[cur];
				qu.addFirst(cur * 2);	
			}

			if(cur + 1 < LEN && dis[cur + 1] > dis[cur] + 1) {			
				dis[cur + 1] = dis[cur] + 1;
				qu.addLast(cur + 1);
			}
			
			if(cur - 1 >= 0 && dis[cur - 1] > dis[cur] + 1) { 
				dis[cur - 1] = dis[cur] + 1;
				qu.addLast(cur - 1);		
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
