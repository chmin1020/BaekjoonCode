import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int prev = -1;
	static int[] seq, ans;
	
	public static void backTracking(int s, int num) throws IOException{
		ans[num] = seq[s];	
		if(num == m - 1) {
			for(int i = 0; i < m; i++) 
				bw.write(ans[i] + " ");
			bw.write("\n");
			return;
		}
		for(int i = s; i < n; i++) {
			if(seq[i] != prev) {
				prev = -1;
				backTracking(i, num + 1);
				prev = seq[i];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		seq = new int[n];
		ans = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(seq);
		
		for(int i = 0; i < n; i++) {
			if(prev != seq[i]) {
				prev = -1;
				backTracking(i, 0);
				prev = seq[i];
			}
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
