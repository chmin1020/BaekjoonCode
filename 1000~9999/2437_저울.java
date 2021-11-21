package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num, cul;
		int[] weights;
		
		num = Integer.parseInt(br.readLine());
		weights = new int[num];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) 
			weights[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(weights);
		
		if(weights[0] != 1)
			bw.write(1 + "\n");
		else {
			cul = 1;
			for(int i = 1; i < num; i++) {
				if(cul + 1 < weights[i]) break;
				cul += weights[i];
			}
			bw.write((cul + 1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
