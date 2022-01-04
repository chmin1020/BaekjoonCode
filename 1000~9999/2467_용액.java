import java.io.*;
import java.util.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] pair = new int[2];
		int[] arr;
		int minVal = 2000000001;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int left = 0, right = n - 1, cur;
		while(left < right) {
			cur = arr[left] + arr[right];
			if(Math.abs(cur) < minVal) {
				minVal = Math.abs(cur);
				pair[0] = arr[left];
				pair[1] = arr[right];
			}
			
			if(cur < 0) left++;
			else right--;
		}
		bw.write(pair[0] + " " + pair[1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
