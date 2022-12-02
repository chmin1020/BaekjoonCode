import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];

		for(int i = 0; i < num; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int lisArr[] = new int[num];
		int end = 0;
		
		lisArr[0] = arr[0];
		for(int i = 1; i < num; i++) {
			if(lisArr[end] < arr[i]) 
				lisArr[++end] = arr[i];
			else {
				int left = 0;
				int right = end;
				
				while(left < right) {
					int mid = (left + right) / 2;
					
					if(lisArr[mid] >= arr[i]) right = mid;
					else left = mid + 1;		
				}
				lisArr[right] = arr[i];
			}
		}
				
		bw.write((num - end - 1) + "\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
