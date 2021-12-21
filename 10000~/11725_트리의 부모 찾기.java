import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> qu = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> tree =  new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cur = null;
		String[] pair = new String[2];
		int n, n1, n2;
		
		n = Integer.parseInt(br.readLine());
		int[] parent = new int[n + 1];
		Arrays.fill(parent, -1);
		parent[1] = 0;
		for(int i = 0; i < n + 1; i++)
			tree.add(new ArrayList<Integer>());
		for(int i = 0; i < n - 1; i++) {
			pair = br.readLine().split(" ");
			n1 = Integer.parseInt(pair[0]);
			n2 = Integer.parseInt(pair[1]);
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		qu.add(1);
		while(!qu.isEmpty()) {
			cur = tree.get(qu.peek());
			for(int i = 0; i < cur.size(); i++) {
				if(parent[cur.get(i)] == -1) {
					parent[cur.get(i)] = qu.peek();
					qu.add(cur.get(i));
				}
			}
			qu.poll();
		}
		
		for(int i = 2; i <= n; i++)
			System.out.println(parent[i]);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
