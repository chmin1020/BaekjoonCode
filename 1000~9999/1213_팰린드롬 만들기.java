import java.io.*;
import java.util.*;

public class Main {	
	public static final int TOENG = 'A';
	
	public static int[] alphabets = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;
		
		String name = br.readLine();
		String answer = "";
		boolean keepGoing = true;
		
		Arrays.fill(alphabets, 0);
		
		for(int i = 0; i < name.length(); i++)
			alphabets[name.charAt(i) - TOENG]++;
		
		int onlyOdd = -1;
		for(int i = 0; i < 26; i++) {
			if(alphabets[i] % 2 == 1) { 
				if(onlyOdd != -1) {
					keepGoing = false;
					break;
				}
				else
					onlyOdd = i;
			}
		}
		
		if(keepGoing) {	
			for(int i = 0; i < 26; i++) {
				int limit = alphabets[i] / 2;
				
				if(i == onlyOdd)
					limit += 1;
				
				while(alphabets[i] > limit) {
					answer += (char)(i + TOENG);
					alphabets[i]--;
				}			
			}
			
			if(onlyOdd != -1) {
				answer += (char)(onlyOdd + TOENG);
				alphabets[onlyOdd]--;
			}
			
			for(int i = 25; i >= 0; i--) {
				while(alphabets[i] > 0) {
					answer += (char)(i + TOENG);
					alphabets[i]--;
				}
			}
			
			bw.write(answer + "\n");
		}
		else
			bw.write("I'm Sorry Hansoo\n");
	
		bw.flush();
		bw.close();
		br.close();
	}
}
