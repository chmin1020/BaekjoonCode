import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 1, cnt, maxN = 0;
		int[][] info;
		int n = Integer.parseInt(br.readLine()); 
		info = new int[n][5];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				info[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			cnt = 0;
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				
				for(int k = 0; k < 5; k++) {
					if(info[i][k] == info[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt > maxN) {
				maxN = cnt;
				ans = i + 1;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
