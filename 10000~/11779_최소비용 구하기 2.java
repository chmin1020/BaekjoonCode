import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1000000001;
	static class Pair implements Comparable<Pair>{
		public int node, cost;
		Pair(int x, int y){
			node = x;
			cost = y;
		}
		public int compareTo(Pair p) {
			return p.cost < this.cost ? 1: -1;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
		boolean visited[];
		ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
		int dijkstra[], before[];
		int cities, buses, start, end, cost;
		Pair cur;
		
		cities = Integer.parseInt(br.readLine());
		buses = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= cities; i++)
			graph.add(new ArrayList<Pair>());
		
		for(int i = 0; i < buses; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Pair(end, cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra = new int[cities + 1];
		before = new int[cities + 1];
		visited = new boolean[cities + 1];
		Arrays.fill(dijkstra, INF);
		Arrays.fill(before, -1);
		Arrays.fill(visited, false);
		
		heap.add(new Pair(start, 0));
		dijkstra[start] = 0;
		Pair next;
		while(!heap.isEmpty()) {
			cur = heap.poll();
			if(visited[cur.node]) continue;
			visited[cur.node] = true;
		
			for(int i = 0; i < graph.get(cur.node).size(); i++) {
				next = graph.get(cur.node).get(i);
				if(dijkstra[next.node] > dijkstra[cur.node] + next.cost) {
					dijkstra[next.node] = dijkstra[cur.node] + next.cost;
					heap.offer(new Pair(next.node, dijkstra[next.node]));
					before[next.node] = cur.node;
				}
			}
		}
		
		int now = end;
		ArrayList<Integer> route = new ArrayList<Integer>();
		route.add(now);
		while(before[now] != -1) {
			route.add(before[now]);
			now = before[now];
		}
		
		bw.write(dijkstra[end]+ "\n");
		bw.write(route.size() + "\n");
		for(int i = route.size() - 1; i >= 0; i--)
			bw.write(route.get(i) + " ");
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
