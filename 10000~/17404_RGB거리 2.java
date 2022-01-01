import java.io.*;
import java.util.*;
	
public class Main {	
	private static final int INF = 1000000001;
	private static int[][] ways;
	private static int num;
	
	public static int solution() {
		int answer = INF;
		int[][] dp = new int[num][3];
		
		for(int i = 0; i < 3; i++) {
			Arrays.fill(dp[0], INF);
			for(int j = 1; j < num; j++)
				Arrays.fill(dp[j], 0);
			dp[0][i] = ways[0][i];
			
			for(int j = 1; j < num; j++)
				for(int k = 0; k < 3; k++)
					dp[j][k] = ways[j][k] + Math.min(dp[j - 1][(k+1)%3], dp[j - 1][(k+2)%3]);
			
			answer = Math.min(answer, Math.min(dp[num - 1][(i+1)%3], dp[num - 1][(i+2)%3]));	
		}
		return answer; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		num = Integer.parseInt(br.readLine());
		ways = new int[num][3];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			ways[i][0] = Integer.parseInt(st.nextToken());
			ways[i][1] = Integer.parseInt(st.nextToken());
			ways[i][2] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(solution() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
