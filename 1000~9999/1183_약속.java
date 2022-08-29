import java.io.*;
import java.util.*;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int[] dataList = new int[num];
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			dataList[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dataList);
		
		if(num %2 == 1)
			bw.write("1\n");
		else
			bw.write((dataList[num/2] - dataList[num/2 - 1] + 1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
