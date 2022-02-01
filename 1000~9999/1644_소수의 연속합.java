import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean[] che = new boolean[5000000];
		int start = 0, end = 0, sum = 0, ans = 0;
		
		
		for(int i = 2; i < 5000000; i++) {
			if(che[i]) continue;
			prime.add(i);
			for(int j = i * 2; j < 5000000; j += i) {
				if(!che[j]) che[j] = true;		
			}
		}
		
		while(prime.get(end) <= n && start <= end && end < prime.size()) {
			sum += prime.get(end++);
			while(sum > n) {
				sum -= prime.get(start++);
			}	
			if(sum == n) ans++;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
