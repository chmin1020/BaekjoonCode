import java.io.*;
import java.util.*;

public class Main {
	static int[] pi;
	static char[] p;
	
	static void findP() {
		int j;
		pi[0] = 0;
		for(int i = 1; i < pi.length; i++) {
			j = pi[i - 1];
			
			while(j > 0) {
				if(p[i] == p[j]) break;
				j = pi[j - 1];
			}
			
			if(p[i] == p[j]) 
				pi[i] = j + 1;
			else 
				pi[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int len;
		String input;
		
		len = Integer.parseInt(br.readLine());
		input = br.readLine();
		p = new char[len];
		p = input.toCharArray();
		
		pi = new int[len];
		findP();		
        
        bw.write((len - pi[len - 1]) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
