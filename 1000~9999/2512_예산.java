import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	private static int[] arr;
	private static int num;
	private static int total;
	private static int answer = Integer.MIN_VALUE;
	
	private static int addAll(int atMost) {
		int result = 0;
		for(int n : arr) 
			result += (n < atMost)?n:atMost;
		return result;
	}
	
	private static void binarySearch(int first, int last) {
		if(first > last)
			return;
		
		int mid = (first + last) / 2;
		int result = addAll(mid);
		
		if(result > total)
			binarySearch(first, mid - 1);
		else {
			answer = Math.max(answer, mid);
			if(result <= total)
				binarySearch(mid + 1, last);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[num];
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		total = Integer.parseInt(br.readLine());
		binarySearch(0, max);
		
		bw.write(answer + "\n");
		
				
		bw.flush();
		bw.close();
		br.close();
	}
}
