import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int paper[][] = new int[101][101];
	static boolean visited[][] = new boolean[101][101];
	
	static class Pair{
		public int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void checkOutside() {
		Queue<Pair> qu = new LinkedList<Pair>();
		Pair cur = null;
		
		for(int i = 1; i <= n; i++)
			Arrays.fill(visited[i], false);
		
		qu.add(new Pair(0, 0));
		visited[0][0] = true;
		
		while(!qu.isEmpty()) {
			cur = qu.poll();
			paper[cur.x][cur.y] = 0; 
			
			if(cur.x - 1 >= 0 && !visited[cur.x - 1][cur.y] && paper[cur.x - 1][cur.y] != 1) {
				visited[cur.x - 1][cur.y] = true;
				qu.add(new Pair(cur.x - 1, cur.y));
			}
			if(cur.x + 1 <= n && !visited[cur.x + 1][cur.y] && paper[cur.x + 1][cur.y] != 1) {
				visited[cur.x + 1][cur.y] = true;
				qu.add(new Pair(cur.x + 1, cur.y));
			}
			if(cur.y - 1 >= 0 && !visited[cur.x][cur.y - 1] && paper[cur.x][cur.y - 1] != 1) {
				visited[cur.x][cur.y - 1] = true;
				qu.add(new Pair(cur.x, cur.y - 1));
			}
			if(cur.y + 1 <= m && !visited[cur.x][cur.y + 1] && paper[cur.x][cur.y + 1] != 1) {
				visited[cur.x][cur.y + 1] = true;
				qu.add(new Pair(cur.x, cur.y + 1));
			}
		}
	}
	
	static boolean checkFour(int x, int y) {
		int cnt = 0;
		if(x - 1 < 1 || paper[x - 1][y] == 0) cnt++;
		if(x + 1 > n || paper[x + 1][y] == 0) cnt++;
		if(y - 1 < 1 || paper[x][y - 1] == 0) cnt++;
		if(y + 1 > m || paper[x][y + 1] == 0) cnt++;
		
		return (cnt >= 2) ? true : false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] readBuf = new String[101];
		Queue<Pair> rest = new LinkedList<Pair>(); 
		Stack<Pair> rm = new Stack<Pair>();
		
		int tmp, result = 0;
		Pair cur = null;
		
		readBuf = br.readLine().split(" ");
		n = Integer.parseInt(readBuf[0]);
		m = Integer.parseInt(readBuf[1]);

		for(int i = 1; i <= n; i++) {
			readBuf = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				if(readBuf[j - 1].equals("0")) paper[i][j] = -1;
				else {
					paper[i][j] = 1;
					rest.add(new Pair(i, j));
				}
			}
		}		
		
		while(!rest.isEmpty()) {
			result++;
			tmp = rest.size();
			
			checkOutside();
			for(int i = 0; i < tmp; i++) {
				cur = rest.poll();
				if(checkFour(cur.x, cur.y))  rm.push(cur);
				else  rest.add(cur);
			}			
			while(!rm.isEmpty()) {
				cur = rm.pop();
				paper[cur.x][cur.y] = -1;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
