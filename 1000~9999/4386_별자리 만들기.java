import java.io.*;
import java.util.*;
	
public class Main {
	static class Pos{
		double x, y;
		Pos(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	static class Pair implements Comparable<Pair>{
		int p;
		double cost;
		Pair(int p, double cost){
			this.p = p;
			this.cost = cost;
		}
		public int compareTo(Main.Pair o) {
			return this.cost > o.cost ? 1 : -1;
		}
	}
	
	public static double solveCost(Pos n1, Pos n2) {
		double cost = Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
		cost = Math.round(cost * 100) / 100.0;
		return cost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Pos[] star;
		double[] cost;
		boolean[] included;
		PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
		double result = 0;
		int n = Integer.parseInt(br.readLine());
		star = new Pos[n];
		included = new boolean[n];
		cost = new double[n];
		Arrays.fill(cost, 1000000001);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			star[i] = new Pos(0, 0);
			star[i].x = Double.parseDouble(st.nextToken());
			star[i].y = Double.parseDouble(st.nextToken());
		}
		
		Pair cur;
		double tmp;
		cost[0] = 0.0;
		heap.offer(new Pair(0, 0.0));
		while(!heap.isEmpty()) {
			cur = heap.poll();
			if(included[cur.p]) continue;
			included[cur.p] = true;
			
			for(int i = 0; i < n; i++) {
				tmp = solveCost(star[cur.p], star[i]);
				if(!included[i] && cost[i] > tmp) {
					cost[i] = tmp;
					heap.offer(new Pair(i, cost[i]));
				}
			}
		}
		
		for(int i = 0; i < n; i++)
			result += cost[i];
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
