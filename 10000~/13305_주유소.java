import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		long[] way = new long[num - 1];
		long[] city = new long[num];
		int cur, check;
		long ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num - 1; i++)
			way[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++)
			city[i] = Integer.parseInt(st.nextToken());		
		
		for(cur = 0; cur != num - 1;) {
			check = cur;
			while(check != num - 1 && (check < num && city[check] >= city[cur])) {
				ans += (city[cur] * way[check]);
				check++;
			}
			cur = check;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
