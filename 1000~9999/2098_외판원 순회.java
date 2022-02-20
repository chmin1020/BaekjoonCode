import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 500000000;
	static int[][] mat, dp;
	static int n;
	
	public static int dfs(int bits, int now) {
		int ret = dp[now][bits];
		if(ret != 0)
			return ret;
		
		if(bits == (1<<n) - 1) {
			if(mat[now][0] != 0)
				return mat[now][0];
			return INF;
		}
		
		ret = INF;
		for(int i = 0; i < n; i++) {
			if(((1<<i) & bits) != 0 || mat[now][i] == 0)
				continue;
				
			ret = Math.min(ret, mat[now][i] + dfs((bits|(1<<i)), i));
		}
		dp[now][bits] = ret;
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		dp = new int[n][1<<n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], 0);
			}
		}
		bw.write(dfs(1, 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
