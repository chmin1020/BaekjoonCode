import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[26];
		char[] ans = new char[26];
		int num = Integer.parseInt(br.readLine());
		int idx, size = 0;
		String name;
		
		Arrays.fill(list, 0);
		Arrays.fill(ans, 'z');
		
		for(int i = 0; i < num; i++) {
			name = br.readLine();
			idx = name.charAt(0) - 'a'; 
			list[idx]++;

			if(list[idx] == 5)
				ans[size++] = name.charAt(0);
		}
		Arrays.sort(ans);
		
		if(size == 0)
			bw.write("PREDAJA\n");
		else {
			for(int i = 0; i < size; i++)
				bw.write(ans[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
