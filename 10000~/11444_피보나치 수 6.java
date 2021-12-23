import java.io.*;
import java.math.BigInteger;

public class Main {
	static final long limit = 1000000007;
	static BigInteger two = new BigInteger("2");
	static BigInteger one = new BigInteger("1");
	static BigInteger zero = new BigInteger("0");
	static long[][] fiboMat = new long[2][2], tmpMat = new long[2][2];
	
	public static void matrixFibo(BigInteger num) {
		if(num.equals(one))
			return;
		
		matrixFibo(num.divide(two));
		tmpMat[0][0] = (fiboMat[0][0] * fiboMat[0][0]) % limit + (fiboMat[0][1] * fiboMat[1][0]) % limit;
		tmpMat[0][1] = (fiboMat[0][0] * fiboMat[0][1]) % limit + (fiboMat[0][1] * fiboMat[1][1]) % limit;
		tmpMat[1][0] = (fiboMat[1][0] * fiboMat[0][0]) % limit + (fiboMat[1][1] * fiboMat[1][0]) % limit;
		tmpMat[1][1] = (fiboMat[1][0] * fiboMat[0][1]) % limit + (fiboMat[1][1] * fiboMat[1][1]) % limit;
			
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				fiboMat[i][j] = tmpMat[i][j] % limit;
		
		if(num.mod(two).equals(one)) {
			tmpMat[0][0] = (fiboMat[0][0] + fiboMat[0][1]) % limit;
			tmpMat[0][1] = fiboMat[0][0];
			tmpMat[1][0] = (fiboMat[1][0] + fiboMat[1][1]) % limit;
			tmpMat[1][1] = fiboMat[1][0];
			
			for(int i = 0; i < 2; i++)
				for(int j = 0; j < 2; j++)
					fiboMat[i][j] = tmpMat[i][j];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;
		//st = new StringTokenizer(br.readLine());
		BigInteger target = new BigInteger(br.readLine());
		fiboMat[0][0] = 1; fiboMat[0][1] = 1;
		fiboMat[1][0] = 1; fiboMat[1][1] = 0;
		
		matrixFibo(target);
		bw.write(fiboMat[0][1] + "\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
