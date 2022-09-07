import java.io.*;
import java.util.*;

public class Main {
	private static Long N, P, Q, X, Y;
	private static Map<Long, Long> table;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		
		
		table = new HashMap<Long, Long>();
		
		bw.write(getAns(N) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static long getAns(long bi) {
		if(bi <= 0L) 
			return 1L;
		
		if(!table.containsKey(bi))
			table.put(bi, getAns(bi/P - X) + getAns(bi/Q - Y));
		
		return table.get(bi);
	}
}
