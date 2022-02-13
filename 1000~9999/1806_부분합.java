import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, s;
		int[] seq;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		seq = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		int sum = seq[0], len = Integer.MAX_VALUE;
		int start = 0, end = 1;
		
		while(start < end && end <= n) {
			if(sum >= s) {
				len = Math.min(len, end - start);
				sum -= seq[start++];
			}
			else {
				if(end == n) break;
				sum += seq[end];
				end++;
			}
		}
		if(len == Integer.MAX_VALUE)
			len = 0;
		
		bw.write(len + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
