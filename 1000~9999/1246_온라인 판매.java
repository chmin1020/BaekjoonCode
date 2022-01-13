import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int egg = Integer.parseInt(st.nextToken());
		int men = Integer.parseInt(st.nextToken());
		int maxVal = -1, num, idx = 0;
		
		int[] price = new int[men];
		for(int i = 0; i < men; i++)
			price[i] = Integer.parseInt(br.readLine());
		Arrays.sort(price);
		
		for(int i = 0; i < men; i++) {
			num = egg;
			if(men - i < egg)
				num = men - i;
			
			if(maxVal < num * price[i]) {
				maxVal = num * price[i];
				idx = i;
			}
		}
		bw.write(price[idx] + " " + maxVal + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
