import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	
	public static boolean check(int one, int two) {
		if(one > two) {
			int tp = one;
			one = two;
			two = tp;
		}
		
		double a = (arr[two] - arr[one]) / ((two - one) * 1.0);
		double b = arr[one] - (a * one);
		
		for(int i = one + 1; i < two; i++)
			if(a * i + b <= arr[i])
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()), tmp, maxN = 0;
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			tmp = 0;
			//System.out.print(i + "에서 ");
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				if(check(i, j)) {
					//System.out.print(j + " ");
					tmp++;
				}
			}
			//System.out.println();
			if(maxN < tmp)
				maxN = tmp;
		}
		
		bw.write(maxN + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
