package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	private static final int LEN = 100001;
	private static boolean[] visited = new boolean[LEN];
	
	public static class Pair implements Comparable<Pair>{
		public int pos, time;
		Pair(int pos, int time){
			this.pos= pos;
			this.time = time;
		}
		public int compareTo(Pair o) {
			return this.time > o.time ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Pair> qu = new PriorityQueue<Pair>();
		int n, k;
		Pair cur = null;
		
		Arrays.fill(visited, false);
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		qu.add(new Pair(n, 0));
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
			if(visited[cur.pos]) continue;
			if(cur.pos == k) {
				bw.write(cur.time + "\n");
				break;
			}
			visited[cur.pos] = true;
				
			if(cur.pos * 2 < LEN && !visited[cur.pos * 2]) 
				qu.add(new Pair(cur.pos * 2, cur.time));
			
			if(cur.pos - 1 >= 0 && !visited[cur.pos - 1]) 
				qu.add(new Pair(cur.pos - 1, cur.time + 1));

			if(cur.pos + 1 < LEN && !visited[cur.pos + 1]) 
				qu.add(new Pair(cur.pos + 1, cur.time + 1));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
