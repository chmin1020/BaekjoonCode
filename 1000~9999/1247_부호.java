import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n; 
		BigInteger res, zero = new BigInteger("0");
		
		for(int tc = 0; tc < 3; tc++) {
			n = Integer.parseInt(br.readLine());
			res = new BigInteger("0");
			for(int i = 0; i < n; i++) 
				res = res.add(new BigInteger(br.readLine()));
			if(res.compareTo(zero) > 0) bw.write("+\n");
			else if(res.compareTo(zero) < 0) bw.write("-\n");
			else bw.write("0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
