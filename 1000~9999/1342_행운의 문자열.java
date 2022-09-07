import java.io.*;
import java.util.*;

public class Main {
	private static int answer = 0;
	private static int strLen;
	private static int[] alphabetCnts = new int[26]; 
	
	private static void dfs(int idx, int len) {
		if(len == strLen) {
			answer++;
			return;
		}
		
		alphabetCnts[idx]--;
		
		for(int i = 0; i < 26; i++)
			if(alphabetCnts[i] > 0 && i != idx)			
				dfs(i, len + 1);
		
		alphabetCnts[idx]++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
	
		Arrays.fill(alphabetCnts, 0);
		
		String str = br.readLine();
		strLen = str.length();
		for(int i = 0; i < strLen; i++)
			alphabetCnts[(int)str.charAt(i) - 97]++;
		
		for(int i = 0; i < 26; i++) {
			if(alphabetCnts[i] > 0) {
				dfs(i, 1);
			}
		}
				
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
