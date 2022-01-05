import java.io.*;
import java.util.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long[] triple = new long[3];
		long[] arr;
		long minVal = 20000000001L;
		int n = Integer.parseInt(br.readLine());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		int left, right;
		long cur;
		for(int i = 0; i < n - 2; i++) {
			left = i + 1; right = n - 1;
			while(left < right) {
				cur = arr[left] + arr[right] + arr[i];
				if(Math.abs(cur) < minVal) {
					minVal = Math.abs(cur);
					triple[0] = arr[i];
					triple[1] = arr[left];
					triple[2] = arr[right];
				}
				
				if(cur < 0) left++;
				else right--;
			}
		}
		bw.write(triple[0] + " " + triple[1] + " " + triple[2] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
