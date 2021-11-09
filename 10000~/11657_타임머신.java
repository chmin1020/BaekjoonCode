package realSpace;
import java.util.Scanner;
import java.util.ArrayList;

class Line{
	public int start, end;
	Line(int s, int e){
		start = s;
		end = e;
	}
}
public class Main {
	private static final int INF = 50000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		int start, end, cost;
		long[] result = new long[501];
		int[][] list = new int[501][501];
		ArrayList<Line> edges = new ArrayList<Line>();
		Line cur = null;
		boolean isPossible = true;
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			result[i] = INF;
			for(int j = 1; j <= n; j++) {
				if(i == j) list[i][j] = 0;
				else list[i][j] = INF;
			}
		}
		result[1] = 0;
		
		for(int i = 0; i < m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			cost = sc.nextInt();
			
			if(list[start][end] > cost) {
				if(list[start][end] == INF)
					edges.add(new Line(start, end));
				list[start][end] = cost;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < edges.size(); j++) {
				cur = edges.get(j);
				if(result[cur.start] == INF) continue;
				if(result[cur.end] > result[cur.start] + list[cur.start][cur.end]) {
					result[cur.end] = result[cur.start] + list[cur.start][cur.end];
					if(i == n - 1)
						isPossible = false;
				}
			}
		}
		
		if(isPossible) {
			for(int i = 2; i <= n; i++) {
				if(result[i] == INF)
					result[i] = -1;
				System.out.println(result[i]);
			}
		}
		else 
			System.out.println(-1);
		
		sc.close();
	}
}
