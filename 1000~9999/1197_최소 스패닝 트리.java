import java.io.*;
import java.util.*;
	
public class Main {	
	static final int INF = 1000000001;
	static int v, e;
	static int[] costArr;
	static boolean[] visited;
	static ArrayList<ArrayList<Vertex>> graph = new ArrayList<ArrayList<Vertex>>();
	static class Vertex implements Comparable<Vertex>{
		public int num, cost;
		Vertex(int num, int cost){
			this.num = num;
			this.cost = cost;
		}
		public int compareTo(Main.Vertex o) {
			return o.cost < this.cost ? 1 : - 1;
		}
	}
	
	public static int prim() {
		int sum = 0;
		Vertex cur, chk;
		PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>();
		
		heap.offer(new Vertex(0, 0));
		costArr[0] = 0;
		while(!heap.isEmpty()) {
			cur = heap.poll();
			if(visited[cur.num])
				continue;
			visited[cur.num] = true;
			for(int i = 0; i < graph.get(cur.num).size(); i++) {
				chk = graph.get(cur.num).get(i);
				if(!visited[chk.num] && costArr[chk.num] > chk.cost) {
					costArr[chk.num] = chk.cost;
					heap.offer(new Vertex(chk.num, costArr[chk.num]));
				}	
			}
		}
		for(int i = 0; i < v; i++)
			sum += costArr[i];
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start, end, cost;
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		costArr = new int[v];
		visited = new boolean[v];
		Arrays.fill(costArr, INF);
		for(int i = 0; i < v; i++)
			graph.add(new ArrayList<Vertex>());
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Vertex(end, cost));
			graph.get(end).add(new Vertex(start, cost));
		}
		bw.write(prim() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
