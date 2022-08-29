import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		
		int dividend = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int reminder = dividend % divisor;
		for(int i = 0; i < n; i++) {
			reminder *= 10;
			answer = reminder / divisor;
			reminder %= divisor;
		}
		
		bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
