import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[5000];
		int[][] cmSum = new int[1025][1025];
		int n, m , x1, y1, x2, y2;
		
		Arrays.fill(cmSum[0], 0);
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		for(int i = 1; i <= n; i++) {
			input = br.readLine().split(" ");			
			for(int j = 1; j <= n; j++) 
				cmSum[i][j] =  cmSum[i - 1][j] + (cmSum[i][j - 1] - cmSum[i - 1][j - 1]) + Integer.parseInt(input[j - 1]);
		}
		
		for(int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			x1 = Integer.parseInt(input[0]);
			y1 = Integer.parseInt(input[1]);
			x2 = Integer.parseInt(input[2]);
			y2 = Integer.parseInt(input[3]);
			bw.write((cmSum[x2][y2] - cmSum[x1 - 1][y2] - cmSum[x2][y1 - 1] + cmSum[x1 - 1][y1 - 1]) + "\n");
		}	
		bw.flush();
		bw.close();
		br.close();
	}
}
