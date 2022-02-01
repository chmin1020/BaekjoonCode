import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	public static int find(int n) {
		if(parent[n] == n) return n;
		else return parent[n] = find(parent[n]);
	}
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		
		if(a > b) parent[b] = parent[a];
		else parent[a] = parent[b];
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0, a, b;
		int nn = Integer.parseInt(st.nextToken());
		int vn = Integer.parseInt(st.nextToken());
		boolean flag = false;
		parent = new int[nn];
		for(int i = 0; i < nn; i++)
			parent[i] = i;
		
		for(int i = 1 ; i <= vn; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(flag) continue;
			if(union(a, b)) {
				ans = i;
        flag = true;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
