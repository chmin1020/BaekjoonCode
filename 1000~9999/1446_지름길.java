import java.io.*;
import java.util.*;

public class Main {	
	private static final int INF = 2000000000;
	
	private static int N, D;
	private static int[] highway;
	private static ArrayList<Path>[] shortcuts;
	
	static class Path{
		int to, dis;
		Path(int to, int dis){
			this.to = to;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		highway = new int[D + 1];
		shortcuts = new ArrayList[D + 1];
		
		Arrays.fill(highway, INF);
		
		for(int i = 0; i < D; i++) {
			shortcuts[i] = new ArrayList<Path>();
			shortcuts[i].add(new Path(i + 1, 1));
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			if(from <= D) 
				shortcuts[from].add(new Path(to, dis));
		}
		
		findWays();
		
		bw.write(highway[D] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void findWays() {
		Queue<Integer> qu = new LinkedList<Integer>();
		int cur;
		
		qu.add(0);
		highway[0] = 0;
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
				
			for(int i = 0; i < shortcuts[cur].size(); i++) {
				Path cut = shortcuts[cur].get(i);
				if(cut.to <= D && highway[cut.to] > highway[cur] + cut.dis) {
					highway[cut.to] = highway[cur] + cut.dis;
					if(cut.to != D)	qu.add(cut.to);
				}
			}
		}
	}
}
