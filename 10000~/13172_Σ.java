import java.io.*;
import java.util.*;
	
public class Main {
	static final long MOD = 1000000007;
	
	public static long square(long num, long up) {
		if(up == 1) return num;
		if(up % 2 == 0) { 
			long dN = square(num, up/2);
			return dN*dN % MOD;
		}
		return square(num, up - 1)*num % MOD;
	}
	
	public static long gcd(long n1, long n2) {
		long tp;
		if(n1 < n2) {
			tp = n1;
			n1 = n2;
			n2 = tp;
		}
		while(n2 != 0) {
			tp = n1 % n2;
			n1 = n2;
			n2 = tp;
		}
		return n1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		long result = 0, dices, n, s, di;
		
		dices = Integer.parseInt(br.readLine());
		for(int i = 0; i < dices; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			di = gcd(n,s);
			n /= di;
			s /= di;
			result += ((s * square(n, MOD - 2)) % MOD);	
			result %= MOD;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
