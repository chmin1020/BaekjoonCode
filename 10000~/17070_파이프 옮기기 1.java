	import java.io.*;
	import java.util.*;
	
	public class Main {
		static final int ROW = 0, COL = 1, DIA = 2;
		static int n, result = 0;
		static boolean map[][];
		
		public static void check(int x, int y, int stat) {
			if(x == n - 1 && y == n - 1) {
				result++;
				return;
			}
			
			if(stat == ROW) {
				if(y + 1 < n && !map[x][y + 1]) {
					check(x, y + 1, ROW);	
					if(x + 1 < n && !map[x + 1][y] && !map[x + 1][y + 1])
						check(x + 1, y + 1, DIA);
				}
			}
			if(stat == COL) {
				if(x + 1 < n && !map[x + 1][y]) {
					check(x + 1, y, COL);	
					if(y + 1 < n && !map[x][y + 1] && !map[x + 1][y + 1])
						check(x + 1, y + 1, DIA);
				}
			}
			if(stat == DIA) {
				if(y + 1 < n && !map[x][y + 1])
					check(x, y + 1, ROW);
				
				if(x + 1 < n && !map[x + 1][y])
					check(x + 1, y, COL);
				
				if(y + 1 < n && !map[x][y + 1] 
						&& x + 1 < n && !map[x + 1][y] && !map[x + 1][y + 1])
						check(x + 1, y + 1, DIA);
			}	
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
	
			n = Integer.parseInt(br.readLine());
			map = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					if(st.nextToken().equals("1"))
						map[i][j] = true;
			}
			
			check(0, 1, ROW);
			
			bw.write(result + "\n");
			bw.flush();
			bw.close();
			br.close();
		}
	}
