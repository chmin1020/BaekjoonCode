import java.io.*;
import java.util.*;
	
public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long[] xPos;
		long[] yPos;
		long result = 0;
		long plus, minus;
		boolean flag = false;
		int n = Integer.parseInt(br.readLine());
		
		xPos = new long[n + 1];
		yPos = new long[n + 1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			xPos[i] = Long.parseLong(st.nextToken());
			yPos[i] = Long.parseLong(st.nextToken());
		}
		xPos[n] = xPos[0];
		yPos[n] = yPos[0];
		
		for(int i = 0; i < n; i++) 
			result += (xPos[i] * yPos[i + 1] - xPos[i + 1] * yPos[i]);
		if(result < 0) result = -result;
		if(result % 2 == 1) flag = true;
		result /= 2;		
		
		bw.write(String.format("%d",result));
		if(flag)
			bw.write(".5");
		else
			bw.write(".0");
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
