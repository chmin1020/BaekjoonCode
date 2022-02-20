import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int house = Integer.parseInt(st.nextToken());
		int wifi = Integer.parseInt(st.nextToken());
		int[] arr = new int[house];
		
		for(int i = 0; i < house; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int left = 1, right = arr[house - 1] - arr[0], mid;
		int cnt, start, ans = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			cnt = 1;
			start = 0;
			for(int i = 1; i < house; i++) {
				if(mid <= arr[i] - arr[start]) {
					start = i;
					cnt++;	
				}
			}
			
			if(cnt < wifi) 
				right = mid - 1;
			else {
				ans = mid;
				left = mid + 1;
			}
		}
	
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
