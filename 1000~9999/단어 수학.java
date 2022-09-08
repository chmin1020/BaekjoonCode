import java.io.*;
import java.util.*;

public class Main {
	static class CharNum implements Comparable<CharNum>{
		char ch;
		int num;
		
		CharNum(char c, int n) {
			ch = c;
			num = n;
		}
		
		public int compareTo(CharNum o) {
			return (this.num < o.num) ? 1 : -1;
		}
	}
	
	private static String[] strs;
	private static CharNum[] charNums = new CharNum[26];
	private static int[] charResults = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		int num = Integer.parseInt(br.readLine());
		strs = new String[num];
		
		for(int i = 0; i < 26; i++)
			charNums[i] = new CharNum((char)('A' + i), 0);
		
		for(int i = 0; i < num; i++) {
			strs[i] = br.readLine();
			int mult = (int)Math.pow(10, strs[i].length() - 1);
			
			for(int j = 0; j < strs[i].length(); j++) {
				int idx = (strs[i].charAt(j) - 'A');
				charNums[idx].num += mult;
				mult /= 10;
			}
		}
			
		Arrays.sort(charNums);
		
		int res = 9;
		for(int i = 0; i < 26; i++) {
			if(charNums[i].num == 0)
				break;
			
			charResults[(int)(charNums[i].ch - 'A')] = res--;
		}
		
		for(int i = 0; i < num; i++) {
			int toNum = 0;
			int mult = (int)Math.pow(10, strs[i].length() - 1);
			
			for(int j = 0; j < strs[i].length(); j++) {
				int idx = (strs[i].charAt(j) - 'A');
				toNum += charResults[idx] * mult;
				mult /= 10;
			}
			answer += toNum;
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
