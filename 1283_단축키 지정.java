import java.io.*;
import java.util.*;

public class Main {
	public static int convert(char ch) {
		if(ch >= 'a')
			return ch - 'a';
		return ch - 'A';
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine()), idx, select;
		boolean[] alpha = new boolean[26];
		String str;
		boolean ready;
		
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			select = -1;
			ready = false;
			
			for(int j = 0; j < str.length(); j++) {
				if(j == 0 || (str.charAt(j - 1) == ' ' && str.charAt(j) != ' ')) {
					idx = convert(str.charAt(j));
					if(!alpha[idx]) {
						alpha[idx] = true;
						select = j;
						ready = true;
						break;
					}
				}
			}
			
			if(!ready) {
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) != ' ') {
					idx = convert(str.charAt(j));
						if(!alpha[idx]) {
							alpha[idx] = true;
							select = j;
							ready = true;
							break;
						}		
					}
				}
			}
			
			for(int j = 0; j < str.length(); j++) {
				if(select == j) 
					bw.write("[" + str.charAt(j) + "]");
				else
					bw.write(str.charAt(j));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
