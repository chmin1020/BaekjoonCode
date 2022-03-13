import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		String origin = br.readLine();
		int left, right, end = origin.length() - 1, tmp = 0;
		
		left = 0; right = end;
		while(tmp < right) {
			if(origin.charAt(left) != origin.charAt(right)) {
				left++;
				continue;
			}	
			tmp = left;
			while(origin.charAt(tmp) == origin.charAt(right)) {
				if(tmp >= right) break;
				tmp++;
				right--;
			}
			if(tmp < right) {
				left++;
				right = end;	
			}
		}
		while(right != end) {
			tmp--;
			right++;
		}
		
		bw.write((end + tmp + 1) + "\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
