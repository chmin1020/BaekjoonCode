import java.io.*;
import java.util.*;

public class Main {
	static class Way{
		public int x, y,time, wall;
		Way(int x, int y,int time, int wall){
			this.x = x;
			this.y = y;
			this.time = time;
			this.wall = wall;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Way> finder = new LinkedList<Way>();
		Way cur = null;
		boolean success = false;
		int n, m;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		String[] map = new String[n];
		int[][] visited = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited[i], 1000000);
			map[i] = br.readLine();
		}
		
		finder.add(new Way(0, 0, 1, 0));
		visited[0][0] = 0;
		while(!finder.isEmpty()) {
			cur = finder.poll();
			
			if(cur.wall > 1) continue;
			if(cur.x == n - 1 && cur.y == m - 1) {
				bw.write(cur.time + "\n");
				success = true;
				break;
			}
			
			
			if(cur.x - 1 >= 0 && visited[cur.x - 1][cur.y] > cur.wall) {
				if(map[cur.x - 1].charAt(cur.y) == '1')
					finder.add(new Way(cur.x - 1, cur.y, cur.time + 1, cur.wall + 1));
				else
					finder.add(new Way(cur.x - 1, cur.y, cur.time + 1, cur.wall));					
				visited[cur.x - 1][cur.y] = cur.wall;
			}
			if(cur.x + 1 < n  && visited[cur.x + 1][cur.y] > cur.wall) {
				if(map[cur.x + 1].charAt(cur.y) == '1')
					finder.add(new Way(cur.x + 1, cur.y, cur.time + 1, cur.wall + 1));
				else 
					finder.add(new Way(cur.x + 1, cur.y, cur.time + 1, cur.wall));						
				visited[cur.x + 1][cur.y] = cur.wall;
			}
			if(cur.y - 1 >= 0 && visited[cur.x][cur.y - 1] > cur.wall) {
				if(map[cur.x].charAt(cur.y - 1) == '1')
					finder.add(new Way(cur.x, cur.y - 1, cur.time + 1, cur.wall + 1));
				else 
					finder.add(new Way(cur.x, cur.y - 1, cur.time + 1, cur.wall));		
				visited[cur.x][cur.y - 1] = cur.wall;
				
			}
			if(cur.y + 1 < m && visited[cur.x][cur.y + 1] > cur.wall) {
				if(map[cur.x].charAt(cur.y + 1) == '1')
					finder.add(new Way(cur.x, cur.y + 1, cur.time + 1, cur.wall + 1));
				else
					finder.add(new Way(cur.x, cur.y + 1, cur.time + 1, cur.wall));	
				visited[cur.x][cur.y + 1] = cur.wall;
			}
		}
		if(!success)
			bw.write(-1 + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
