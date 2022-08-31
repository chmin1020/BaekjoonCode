import java.io.*;
import java.util.*;

public class Main {	
	private static int ansW = 0, ansB = 0;
	private static int N, M;
	private static boolean[][] visited;
	private static char[][] map;
	
	private static int[] xDirect = { -1, 1, 0, 0};
	private static int[] yDirect = { 0, 0, -1, 1};
	
	private static class Pos{
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static void bfs(int one, int two, char tar){
		int totPower = 1;
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(one, two));
		
		visited[one][two] = true;
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int tarX = cur.x + xDirect[i];
				int tarY = cur.y + yDirect[i];
				
				if(inXRange(tarX) && inYRange(tarY)) {
					if(!visited[tarX][tarY] && map[tarX][tarY] == tar) {
						visited[tarX][tarY] = true;
						totPower++;
						queue.add(new Pos(tarX, tarY));
					}
				}
			}
		}
		
		totPower *= totPower;
		
		if(tar == 'B')
			ansB += totPower;
		else
			ansW += totPower;
	}
	
	private static boolean inXRange(int x) {
		if(x >= 0 && x < M)
			return true;
		return false;
	}
	
	private static boolean inYRange(int y) {
		if(y >= 0 && y < N)
			return true;
		return false;	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M][N];
		map = new char[M][N];
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			char[] chars = str.toCharArray();
			
			for(int j = 0; j < N; j++)
				map[i][j] = chars[j];
		}
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++) 
				if(!visited[i][j])
					bfs(i, j, map[i][j]);
		
		bw.write(ansW + " " + ansB + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
