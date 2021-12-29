import java.io.*;
import java.util.*;
	
public class Main {	
	static Pos[] dots = new Pos[20];
	static boolean[] visited = new boolean[20];
	static int num;
	static long sumX, sumY;
	static double res;
	static class Pos{
		public int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void dfs(int from, int now) {
		if(now == num / 2) {
			res = Math.min(res, checkNow());
			return;
		}
		for(int i = from; i < num; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i + 1, now + 1);
				visited[i] = false;
			}
		}
	}
	
	public static double checkNow() {
		long tpSumX = sumX, tpSumY = sumY;
		
		for(int i = 0; i < num; i++) {
			if(visited[i]) {
				tpSumX -= (2 * dots[i].x);
				tpSumY -= (2 * dots[i].y);
			}
		}
		return Math.sqrt((double)(tpSumX * tpSumX + tpSumY * tpSumY));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cases = Integer.parseInt(br.readLine());
		int tx, ty;
		
		for(int i = 0; i < cases; i++) {
			num = Integer.parseInt(br.readLine());
			sumX = 0; sumY = 0;
			res = 100000001;
			for(int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				tx = Integer.parseInt(st.nextToken());
				ty = Integer.parseInt(st.nextToken());
				dots[j] = new Pos(tx, ty);
				sumX += tx; sumY += ty;
			}
			dfs(0, 0);
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
