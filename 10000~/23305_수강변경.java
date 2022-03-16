import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][n];
		
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr[i]);
		}
		
		int cnt = 0, ptr = 0;
		for(int i = 0; i < n; i++) {
			while(ptr < n && arr[0][i] > arr[1][ptr])
				ptr++;
			
			if(ptr >= n) break;
			if(arr[0][i] == arr[1][ptr]) {
				cnt++;
				ptr++;
			}
		}
		bw.write((n - cnt) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
