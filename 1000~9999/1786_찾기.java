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
		String input;
		ArrayList<Integer> pos = new ArrayList<Integer>();
		char[] t;
		int idx, cnt, ans;
		
		input = br.readLine();
		t = new char[input.length()];
		t = input.toCharArray();
		
		input = br.readLine();
		p = new char[input.length()];
		p = input.toCharArray();
		
		pi = new int[input.length()];
		findP();
		
		idx = cnt = ans = 0;
        while(idx < t.length) {
            if(t[idx] == p[cnt]) {
                if(cnt == p.length - 1) {
                    ans++;
                    pos.add(idx - p.length + 2);
                    cnt = pi[cnt];
                }
                else cnt++;
                idx++;
            } 
            else if(cnt > 0) cnt = pi[cnt - 1];
            else idx++;
        }
        
        bw.write(ans + "\n");
        for(int i = 0; i < pos.size(); i++)
        	bw.write(pos.get(i) + " ");
        bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
