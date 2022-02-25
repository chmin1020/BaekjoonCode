import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	public static void union(int a, int b) {
		int pA = find(a), pB = find(b);
		if(pA != pB) {
			if(pA < pB)
				parent[pB] = pA;
			else
				parent[pA] = pB;
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n)
			return n;
		else
			return parent[n] = find(parent[n]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for(int i = 0; i <= n; i++)
			parent[i] = i;
		
		int select, a, b;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			select = Integer.parseInt(st.nextToken());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(select == 0)
				union(a, b);
			else {
				if(find(a) == find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
