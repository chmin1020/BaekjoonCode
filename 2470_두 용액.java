import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[n];
		
		for(int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(seq);
		
		int start = 0, end = n - 1, tmp, cmp = Integer.MAX_VALUE;
		int[] ans = new int[2];
		while(start < end) {
			tmp = seq[start] + seq[end];
			if(Math.abs(tmp) < cmp) {
				cmp = Math.abs(tmp);
				ans[0] = seq[start];
				ans[1] = seq[end];
			}
			
			if(tmp < 0)
				start++;
			else
				end--;
		}
		bw.write(ans[0] + " " + ans[1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
