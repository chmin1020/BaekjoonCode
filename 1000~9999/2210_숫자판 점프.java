import java.io.*;
import java.util.*;

public class Main {
	private static char[][] pan = new char[5][5];
	private static int[] directX = {0, 0, -1, 1};
	private static int[] directY = {1, -1, 0, 0};
	
	private static Set<String> set = new HashSet<String>();
	
	private static void dfs(int x, int y, String str) {
		String cur = str + pan[x][y];
		
		if(cur.length() == 6) {
			set.add(cur);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int curX = x + directX[i];
			int curY = y + directY[i];
			
			if(checkLimit(curX) && checkLimit(curY))
				dfs(x + directX[i], y + directY[i], cur);
		}
	}
	
	private static boolean checkLimit(int n) {
		return (n >= 0 && n < 5)? true : false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;		
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) 
				pan[i][j] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				dfs(i, j, "");
		
		bw.write(set.size() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
