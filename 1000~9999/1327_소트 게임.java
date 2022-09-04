import java.io.*;
import java.util.*;

public class Main {
	private static int K, N;
	private static Map<String, Integer> table = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		String first = "";
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			first += st.nextToken();
		
		char[] tmp = first.toCharArray();
		Arrays.sort(tmp);
		String target = "";
		
		for(int i = 0; i < tmp.length; i++) 
			target += tmp[i];
		
		table.put(first, 0);
			
		bw.write(bfs(first, target) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int bfs(String first, String target) {
		Queue<String> qu = new LinkedList<String>();
		int result = -1;
		String cur;
		
		qu.add(first);
		while(!qu.isEmpty()) {
			cur = qu.poll();
			
			if(cur.equals(target)) {
				result = table.get(cur);
				break;
			}
			
			for(int i = 0; i <= cur.length() - K; i++) {
				String sub = cur.substring(i, i + K);
				String tmp = cur.replace(sub, reverse(sub));
			
				if(!table.containsKey(tmp)) {
					table.put(tmp, table.get(cur) + 1);
					qu.add(tmp);
				}
			}
		}
		
		return result;
	}
	
	private static String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}
}
