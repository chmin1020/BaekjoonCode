import java.io.*;
import java.util.*;

public class Main {
	private static double answer = 0;
	private static int num;
	private static double[] probs = new double[4];
	private static int[] directX = {0, 0, 1, -1};
	private static int[] directY = {1, -1, 0, 0};
	
	private static boolean[][] visitedMap= new boolean[29][29];
	
	private static void doDFS(double prob, int cnt, int x, int y) {
		if(prob == 0.0) return;
		if(visitedMap[x][y]) return;
		
		visitedMap[x][y] = true;
		
		if(cnt == num)
			answer += prob;
		else {
			for(int i = 0; i < 4; i++) 
				doDFS(prob * probs[i], cnt + 1, x + directX[i], y + directY[i]);
		}	
		
		visitedMap[x][y] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; i++)
			probs[i] = Double.parseDouble(st.nextToken()) / 100.0;		
		
		for(int i = 0; i < 4; i++)
			doDFS(probs[i], 0, 14, 14);

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
