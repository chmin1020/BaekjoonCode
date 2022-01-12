import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int[] way = new int[num - 1];
		int[] city = new int[num];
		int cur, check, ans = 0;
		
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
