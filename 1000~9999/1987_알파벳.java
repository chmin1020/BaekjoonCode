import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static boolean[] alphabet;
	static int r, c, ans = 0;
	
	public static void backTracking(int x, int y, int cnt) {
		if(cnt > ans) ans = cnt;
		visited[x][y] = true;
		alphabet[map[x][y] - 'A'] = true;
		
		if(x - 1 >= 0 && !visited[x - 1][y] && !alphabet[map[x - 1][y] - 'A']) 
			backTracking(x - 1, y, cnt + 1);
		if(x + 1 < r && !visited[x + 1][y] && !alphabet[map[x + 1][y] - 'A']) 
			backTracking(x + 1, y, cnt + 1);
		if(y - 1 >= 0 && !visited[x][y - 1] && !alphabet[map[x][y - 1] - 'A']) 
			backTracking(x, y - 1, cnt + 1);
		if(y + 1 < c && !visited[x][y + 1] && !alphabet[map[x][y + 1] - 'A']) 
			backTracking(x, y + 1, cnt + 1);

		visited[x][y] = false;
		alphabet[map[x][y] - 'A'] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		alphabet = new boolean[26];
		
		String input;
		for(int i = 0; i < r; i++) {
			input = br.readLine();
			map[i] = input.toCharArray();
		}
		backTracking(0, 0, 1);
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
