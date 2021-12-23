import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void backTracking(int s, int num, int[] seq, int[] ans) throws IOException{
		ans[num] = seq[s];	
		if(num == m - 1) {
			for(int i = 0; i < m; i++)
				bw.write(ans[i] + " ");
			bw.write("\n");
			return;
		}
		for(int i = s; i < n; i++) 
			backTracking(i, num + 1, seq, ans);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] seq, ans;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		seq = new int[n];
		ans = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(seq);
		
		for(int i = 0; i < n; i++)
			backTracking(i, 0, seq, ans);
		bw.flush();
		bw.close();
		br.close();
	}
}
