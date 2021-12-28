import java.io.*;
import java.util.*;
	
public class Main {
	static final int INF = 200000001;
	static int[] items;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int n, m, r;
	
	static class Node implements Comparable<Node>{
		public int num, cost;
		Node(int num, int cost){
			this.num = num;
			this.cost = cost;
		}
		public int compareTo(Main.Node o) {
			return this.cost > o.cost ? 1 : -1;
		}
	}
	public static int findAndCheck(int start) {
		int result = 0;
		int[] optimal = new int[n];
		boolean[] visited = new boolean[n];
		PriorityQueue<Node> qu = new PriorityQueue<Node>();
		Node cur = null, now = null;
		
		Arrays.fill(optimal, INF);	
		Arrays.fill(visited, false);
		optimal[start] = 0;
		qu.offer(new Node(start, 0));
		while(!qu.isEmpty()) {
			cur = qu.poll();
			if(visited[cur.num]) continue;
			visited[cur.num] = true;
			
			for(int i = 0; i < graph.get(cur.num).size(); i++) {
				now = graph.get(cur.num).get(i);
				if(optimal[now.num] > now.cost + optimal[cur.num]) {
					optimal[now.num] = now.cost + optimal[cur.num];
					qu.offer(new Node(now.num, optimal[now.num]));
				}
			}
		}
		
		for(int i = 0; i < n; i++)
			if(optimal[i] <= m)
				result += items[i];
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = -1;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<Node>());
			items[i] = Integer.parseInt(st.nextToken());
		}
			
		int s, e, c;
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()) - 1;
			e = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node(e, c));
			graph.get(e).add(new Node(s, c));
		}
		
		for(int i = 0; i < n; i++) 
			ans = Math.max(ans, findAndCheck(i));
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
