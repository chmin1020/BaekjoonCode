import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int full = 0, less, more, lessLen, moreLen, ans;
		boolean success;
		String input;
		boolean[][] gear = new boolean[2][];
		
		for(int i = 0; i < 2; i++) {
			input = br.readLine();
			full += input.length();
			gear[i] = new boolean[input.length()];
			for(int j = 0; j < input.length(); j++)
				gear[i][j] = (input.charAt(j) == '1') ? true : false;
		}
		ans = full;
		less = (gear[0].length < gear[1].length)? 0 : 1;
		more = (less == 1)? 0 : 1;
		lessLen = gear[less].length;
		moreLen = gear[more].length;
		
		boolean[] tmp = new boolean[moreLen];
		tmp = gear[more];
		gear[more] = new boolean[2 * lessLen + moreLen];
		Arrays.fill(gear[more], true);
		for(int i = lessLen; i < lessLen + tmp.length; i++)
			gear[more][i] = tmp[i - lessLen];
		
		
		for(int i = 0; i < gear[more].length - lessLen; i++) {
			success = true;
			int t = 0;
			for(int j = 0; j < lessLen; j++) {
				if((i + j) >= lessLen && (i + j) < lessLen + moreLen)
					t++;
				if(!(gear[less][j] || gear[more][i + j])) {
					success = false;
					break;
				}
			}
			if(success)
				ans = Math.min(ans, full - t);
			if(ans == moreLen)
				break;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
