import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	private static Queue<Integer> start = new LinkedList<Integer>();
	private static Queue<Integer> end = new LinkedList<Integer>();
	
	
	private static String getCnt(int n) {
		BigInteger bi = new BigInteger("1");
		
		for(int i = 0; i < n; i++)
			bi = bi.multiply(BigInteger.TWO);
		bi = bi.subtract(BigInteger.ONE);
		
		return bi.toString();
	}
	
	private static void hanoi(int n, int from, int by, int to) {
		if(n == 0)
			return;
			
		hanoi(n - 1, from, to, by);
		start.add(from);
		end.add(to);
		hanoi(n - 1, by, from, to);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(getCnt(n) + "\n");
		if(n <= 20) {
			hanoi(n, 1, 2, 3);	
			while(!start.isEmpty())
				bw.write(start.poll() + " " + end.poll() + "\n");
		}
				
		bw.flush();
		bw.close();
		br.close();
	}
}
