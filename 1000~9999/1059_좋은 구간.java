import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int tar, idx, start, end, ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		tar = Integer.parseInt(br.readLine());
		
		idx = 0;
		while(arr[idx] < tar)
			idx++;
		if(arr[idx] != tar) {
			end = arr[idx] - 1;
			idx--;
			if(idx < 0)
				start = 1;
			else
				start = arr[idx] + 1;
			
			ans = (tar - start) * (end - tar + 1) + (end - tar);
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
