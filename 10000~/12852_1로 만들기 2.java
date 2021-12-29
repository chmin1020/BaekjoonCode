import java.io.*;
import java.util.*;
	
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st 
		Queue<Integer> qu = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int start = Integer.parseInt(br.readLine()), cur;
		int[] dp = new int[start + 1], before = new int[start + 1];
		Arrays.fill(dp, -1);
		Arrays.fill(before, -1);
		
		qu.offer(start);
		dp[start] = 0;
		while(!qu.isEmpty()) {
			cur = qu.poll();
			if(cur == 1)
				break;
			
			if(cur % 3 == 0) {
				if(dp[cur / 3] == -1) {
					dp[cur / 3] = dp[cur] + 1;
					before[cur / 3] = cur;
					qu.offer(cur / 3);
				}
			}
			if(cur % 2 == 0) {
				if(dp[cur / 2] == -1) {
					dp[cur / 2] = dp[cur] + 1;
					before[cur / 2] = cur;	
					qu.offer(cur / 2);
				}
			}
			if(dp[cur - 1] == -1) {
				dp[cur - 1] = dp[cur] + 1;
				before[cur - 1] = cur;
				qu.offer(cur - 1);
			}
		}
		
		cur = 1;
		while(cur != -1) {
			list.add(cur);
			cur = before[cur];
		}
		
		bw.write(dp[1] + "\n");
		for(int i = list.size() - 1; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
