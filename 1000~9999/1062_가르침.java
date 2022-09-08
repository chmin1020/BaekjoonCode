import java.io.*;
import java.util.*;

public class Main {
	private static int N, K;
	private static int answer = 0;
	private static int[] words;
		
	private static void dfs(int n, int cur, int comp) {
		if(n == K) {
			int avail = 0;
			for(int i = 0 ; i < words.length; i++) 
				if((comp & words[i]) == words[i]) 
					avail++;

			answer = Math.max(answer, avail);
			
			return;
		}
		
		for(int i = cur + 1; i < 26; i++)
			dfs(n + 1, i, (comp | (1 << i)));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new int[N];
		Arrays.fill(words, 0);
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				int ctoi = (int)(str.charAt(j) - 'a');
				int bitmask = 1 << ctoi;		
				words[i] = (words[i] | bitmask);
			}
		}
		
		for(int i = 0; i < 26; i++)
			dfs(1, i, (1 << i));
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
