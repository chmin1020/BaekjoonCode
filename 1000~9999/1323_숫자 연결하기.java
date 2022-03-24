import java.io.*;
import java.util.*;

public class Main {	
	public static long decideMul(int n) {
		long mul = 0;
		while (n > 0) {
			mul++;
			n /= 10;
		}
		mul = (long) Math.pow(10, mul);
		return mul;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 1;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long mul = decideMul(n);
		boolean[] rest = new boolean[k];
		
		long mod = n % k;
		while(mod != 0) {
			mod = (mod * mul + n) % k;
			if(rest[(int)mod]) {
				ans = -1;
				break;
			}
			rest[(int)mod] = true;
			ans++;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
