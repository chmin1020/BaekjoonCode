import java.io.*;
import java.util.*;

public class Main {
	static int n, m, zeroNum = 0;
	static int map[][] = new int[8][8];
	static boolean visited[][] = new boolean[8][8];
	static ArrayList<Pair> virus = new ArrayList<Pair>();
	
	static class Pair{
		public int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int doBFS(Pair a, Pair b, Pair c) {
		Queue<Pair> qu = new LinkedList<Pair>();
		Pair cur = null;
		int vNum = 0;
		
		for(int i = 0; i < n; i++)
			Arrays.fill(visited[i], false);
		
		for(int i = 0; i < virus.size(); i++) {
			qu.add(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}
		map[a.x][a.y] = 1;
		map[b.x][b.y] = 1;
		map[c.x][c.y] = 1;
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
			if(map[cur.x][cur.y] == 0)
				vNum++;
			
			if(cur.x - 1 >= 0 && !visited[cur.x - 1][cur.y] && map[cur.x - 1][cur.y] != 1) {
				visited[cur.x - 1][cur.y] = true;
				qu.add(new Pair(cur.x - 1, cur.y));
			}
			if(cur.x + 1 < n && !visited[cur.x + 1][cur.y] && map[cur.x + 1][cur.y] != 1) {
				visited[cur.x + 1][cur.y] = true;
				qu.add(new Pair(cur.x + 1, cur.y));
			}
			if(cur.y - 1 >= 0 && !visited[cur.x][cur.y - 1] && map[cur.x][cur.y - 1] != 1) {
				visited[cur.x][cur.y - 1] = true;
				qu.add(new Pair(cur.x, cur.y - 1));
			}
			if(cur.y + 1 < m && !visited[cur.x][cur.y + 1]  && map[cur.x][cur.y + 1] != 1) {
				visited[cur.x][cur.y + 1] = true;
				qu.add(new Pair(cur.x, cur.y + 1));
			}
		}
		map[a.x][a.y] = 0;
		map[b.x][b.y] = 0;
		map[c.x][c.y] = 0;
		
		return zeroNum - vNum - 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] readBuf = new String[101];
		ArrayList<Pair> zeros = new ArrayList<Pair>(); 
		int result = 0;
		
		readBuf = br.readLine().split(" ");
		n = Integer.parseInt(readBuf[0]);
		m = Integer.parseInt(readBuf[1]);

		for(int i = 0; i < n; i++) {
			readBuf = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				if(readBuf[j].equals("0")) {
					zeros.add(new Pair(i, j));
					zeroNum++;
					map[i][j] = 0;
				}
				else if(readBuf[j].equals("1"))
					map[i][j] = 1;
				else {
					map[i][j] = 2;
					virus.add(new Pair(i, j));
				}
			}
		}		
		
		for(int i = 0; i < zeros.size(); i++) 
			for(int j = i + 1; j < zeros.size(); j++) 
				for(int k = j + 1; k < zeros.size(); k++) 
					result = Math.max(doBFS(zeros.get(i), zeros.get(j), zeros.get(k)), result);
			
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
