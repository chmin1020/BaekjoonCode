import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[2000];
		int[] line = new int[500];
		double[] avg = new double[500];
		int n, k;		
		double result = -1, tmp, curAvg;
		
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		line[0] = Integer.parseInt(input[0]);
		avg[0] = line[0];
		for(int i = 1; i < n; i++) {
			line[i] = Integer.parseInt(input[i]);
			avg[i] = avg[i - 1] + line[i]; 
		}
		
		for(int i = 0; i < n; i++)
			avg[i] = avg[i] / (i + 1);
		
		for(int i = k; i <= n; i++) {
			for(int j  = 0; j + i <= n; j++) {
				tmp = 0;
				curAvg = (avg[j + i - 1] * (j + i) - avg[j] * (j + 1) + line[j]) / i; 
				for(int l = j; l < j + i; l++) 
					tmp += Math.pow(line[l] - curAvg, 2);
				tmp /= i;
				tmp = Math.sqrt(tmp);
				if(result == -1 || result > tmp)
					result = tmp;
			}
		}
		bw.write(result + "\n");
		//bw.write(String.format("%.11f",result) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
