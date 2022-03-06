import java.io.*;
import java.util.*;

public class Main {
	static int visited = 0, n, ans = 0;
	static int[] seq;
	static boolean[] graph = new boolean[101];
	
	public static void arrange(int num, int ptr) {
		graph[ptr + seq[num]] = true;
		visited = visited | (1<<num);
		//System.out.println((ptr + seq[num]) +"은 트루고 visited는 " + visited + "다");
		
		if(visited == (1<<n) - 1) {
			int tmp = 0;
			for(int i = 0; i <= 50; i++) {
				if(graph[i] && graph[i + 50])
					tmp++;
			}
			ans = Math.max(ans, tmp);
			graph[ptr + seq[num]] = false;
			visited = visited - (1<<num);
			return;	
		}
		
		for(int i = 0; i < n; i++) {
			if((visited & 1<<i) == 0)
				arrange(i, ptr + seq[num]);		
		}
		graph[ptr + seq[num]] = false;
		visited = visited - (1<<num);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			//System.out.println("<<자 다시 시작이야>>");
			arrange(i, 0);
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
