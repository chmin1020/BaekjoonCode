import java.io.*;
import java.util.*;

public class Main {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int start, target, result = 1;
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(start == target)
				break;
			else if(start > target) {
				result = -1;
				break;
			}
			else {
				result++;
				if(target % 10 == 1)
					target = (target - 1) / 10;
				else if(target % 2 == 0)
					target /= 2;
				else {
					result = -1;
					break;
				}	
			}		
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
