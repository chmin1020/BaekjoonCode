import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb;
		String word = br.readLine();
		String ans = "";
		String tmp = "";
		
		for(int i = 0; i < word.length(); i++)
			ans += 'z';
		
		for(int i = 1; i < word.length() - 1; i++) {
			for(int j = i + 1; j < word.length(); j++) {				
				tmp = "";
				sb = new StringBuffer(word.substring(0, i));
				tmp += sb.reverse().toString();
					
				sb = new StringBuffer(word.substring(i , j));
				tmp += sb.reverse().toString();
				
				sb = new StringBuffer(word.substring(j, word.length()));
				tmp += sb.reverse().toString();
					
				if(tmp.compareTo(ans) < 0)
					ans = tmp;
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
