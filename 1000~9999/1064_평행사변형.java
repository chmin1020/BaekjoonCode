import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] x = new int[3], y = new int[3];
		double[] line = new double[3];
		
		for(int i = 0; i < 3; i++) {
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		if((x[0] - x[1]) * (y[0] - y[2]) == (x[0] - x[2]) * (y[0] - y[1]))
			bw.write("-1.0\n");
		else {
			int i = 0;
			for(int j = 0; j < 3; j++) 
				for(int k = j + 1; k < 3; k++, i++) 
					line[i] = Math.sqrt(Math.pow(x[j] - x[k], 2) + Math.pow(y[j] - y[k], 2));
			
			Arrays.sort(line);
			bw.write(String.format("%.10f",(line[2] - line[0]) * 2) + "\n");

		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
