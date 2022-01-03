import java.io.*;
import java.util.*;
	
public class Main {
	private static long[] nArr, mArr;
	private static ArrayList<Long> culMList = new ArrayList<Long>();
	private static int T, n, m;
	
	public static long binary(int left, int right, long target) {
		if(left > right) return 0;
		int mid = (left + right) / 2;
		
		if(culMList.get(mid) == target) 
			return upperBound(0, culMList.size(), target) - lowerBound(0, culMList.size(), target);
		else if(culMList.get(mid) > target)
			return binary(left, mid - 1, target);
		else
			return binary(mid + 1, right, target);
	}
	
	public static long upperBound(int left, int right, long target) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(culMList.get(mid) <= target) 
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
	public static long lowerBound(int left, int right, long target) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(culMList.get(mid) < target) 
				left = mid + 1;
			else
				right = mid;
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Long> heap = new PriorityQueue<Long>(); 
		long result = 0;
		
		T = Integer.parseInt(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		nArr = new long[n];
		st = new StringTokenizer(br.readLine());
		nArr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < n; i++)
			nArr[i] = Integer.parseInt(st.nextToken()) + nArr[i - 1];
		
		m = Integer.parseInt(br.readLine());
		mArr = new long[m];
		st = new StringTokenizer(br.readLine());
		mArr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < m; i++)
			mArr[i] = Integer.parseInt(st.nextToken()) + mArr[i - 1];
		
		for(int i = 0; i < m; i++) {
			for(int j = i; j < m; j++) {
				if(i == 0)
					heap.offer(mArr[j]);
				else
					heap.offer(mArr[j] - mArr[i - 1]);
			}
		}		
		while(!heap.isEmpty()) 
			culMList.add(heap.poll());
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(i == 0) 
					result += binary(0, culMList.size() - 1, T - nArr[j]);			
				else 
					result += binary(0, culMList.size() - 1, T - (nArr[j] - nArr[i - 1]));
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
