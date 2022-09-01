import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	private static BigInteger N, P, Q;
	private static Map<BigInteger, BigInteger> table;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = new BigInteger(st.nextToken());
		P = new BigInteger(st.nextToken());
		Q = new BigInteger(st.nextToken());
		
		table = new HashMap<BigInteger, BigInteger>();
		table.put(BigInteger.ZERO, BigInteger.ONE);
		
		bw.write(getAns(N).toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static BigInteger getAns(BigInteger bi) {
		if(!table.containsKey(bi))
			table.put(bi, getAns(bi.divide(P)).add(getAns(bi.divide(Q))));
		return table.get(bi);
	}
}
