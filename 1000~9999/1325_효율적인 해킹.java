import java.io.*;
import java.util.*;

public class Main {	
	public static int n, m;
	public static ArrayList<Integer>[] graph;
	public static int[] cnts;
	public static boolean visited[];
	
	public static void doBFS(int idx) {
		Queue<Integer> qu = new LinkedList<Integer>();

		visited[idx] = true;
		qu.add(idx);
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			
			for(int i = 0; i < graph[cur].size(); i++) {
				int tmp = graph[cur].get(i);
				if(!visited[tmp]) {
					cnts[tmp]++;
					visited[tmp] = true;
					qu.add(tmp);
				}	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		cnts = new int[n + 1];
		
		Arrays.fill(cnts, 0);
		
		for(int i = 1; i <= n; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
		
			graph[end].add(start);
		}
		
		
		for(int i = 1; i <= n; i++) { 
			visited = new boolean[n + 1];
			doBFS(i);
		}
		
		int max = -1;
		for(int i = 1; i <= n; i++) 
			max = Math.max(cnts[i], max);
	
		for(int i = 1; i <= n; i++)
			if(max == cnts[i])
				bw.write(i + " ");		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
