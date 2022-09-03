import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnts = Integer.parseInt(br.readLine());
		
		int[] seq = new int[cnts];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < cnts; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		int chance = Integer.parseInt(br.readLine());
		
		int target = 0;
		while(chance > 0 && target < cnts) {
			int best = target;
			
			for(int i = target; i < cnts; i++) 
				if(seq[best] < seq[i] && chance >= i - target) 
					best = i;	
			
			int tmp = seq[target];
			seq[target] = seq[best];
			for(int i = target; i < best; i++) {
				int tp = seq[i + 1];
				seq[i + 1] = tmp;
				tmp = tp;
			}
					
			chance -= (best - target);
			target++;
		}
		
		for(int i = 0; i < cnts; i++)
			bw.write(seq[i] + " ");
		bw.write("\n");	
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
