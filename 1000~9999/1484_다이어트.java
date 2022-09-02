import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int G = Integer.parseInt(br.readLine());
		int cur = 2, exp = 1;
		ArrayList<Integer> results = new ArrayList<Integer>(); 
		
		while(cur != exp) {
			int res = cur * cur - exp * exp;
			if(res >= G) {
				if(res == G) 
					results.add(cur);
				exp++;
			}
			else
				cur++;	
		}
		
		if(results.size() == 0)
			bw.write("-1\n");
		else {
			for(int i = 0; i < results.size(); i++)
				bw.write(results.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
