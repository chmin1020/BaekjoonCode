import java.io.*;
import java.util.*;

public class Main {
	public static boolean isSquare(long num) {
		long s = Math.round(Math.sqrt(num));
		if(s*s == num)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++)
				arr[i][j] = input.charAt(j) - '0';
		}
		
		int cx, cy, tp, ans = -1;
		//i와 j는 시작점
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = -n; k < n; k++) {
					for(int l = -m; l < m; l++) {
						tp = arr[i][j];
						if(k == 0 && l == 0) {
							if(isSquare(tp))
								ans = Math.max(ans, tp);
							continue;
						}
						cx = i + k;
						cy = j + l;
						while((cx >= 0 && cx < n) && (cy >= 0 && cy < m)) {
							tp = tp * 10 + arr[cx][cy];
							if(isSquare(tp))
								ans = Math.max(ans, tp);
							cx += k;
							cy += l;
						}
					}
				}
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
