import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long L = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long H = Integer.parseInt(st.nextToken());
		
		double low = 0, high = Math.min(L, Math.min(W,  H)), mid = 0;
		for(int i = 0; i < 100000; i++) {
			mid = (low + high) / 2;
			if((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) low = mid;
			else high = mid;
		}
		bw.write(Double.toString(mid) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
