import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n;
		int[][] arr;
		int[] sum;
		
		for(int ca = 0; ca < t; ca++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[n + 1][n + 1];
			sum = new int[n + 1];
			Arrays.fill(sum, 0);
			
			for(int j = 1; j <= n; j++) 
				sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
			
			for(int k = 1; k < n; k++){
	            int i = 1;
	            int j = k + 1;
	            for(int u = 0; u < n - k; u++){
	                arr[i][j] = Integer.MAX_VALUE;
	                for(int m = j - k; m <= j - 1; m++)
	                    arr[i][j] = Math.min(arr[i][j], arr[i][m]+ arr[m + 1][j]+ sum[j] - sum[i - 1]);
	                i++; j++;
	            }
	        }
			bw.write(arr[1][n] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
