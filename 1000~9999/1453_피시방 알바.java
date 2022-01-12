import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[] pos = new boolean[100];
		int num = Integer.parseInt(br.readLine());
		int order, ans = 0;
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			order = Integer.parseInt(st.nextToken());
			if(pos[order - 1])
				ans++;
			else
				pos[order - 1] = true;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
