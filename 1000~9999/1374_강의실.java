import java.io.*;
import java.util.*;

public class Main {
	
	static class Time implements Comparable<Time>{
		int start, end;
		
		Time(int s, int e){
			start = s;
			end = e;
		}
		
		public int compareTo(Time o) {
			return (this.start > o.start) ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Time> times = new PriorityQueue<Time>();
		PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();
		
		int ans = 0;
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			times.add(new Time(start, end));
		}
		
		while(!times.isEmpty()) {
			Time cur = times.poll();
			
			if(!rooms.isEmpty() && rooms.peek() <= cur.start)
				rooms.poll();
			
			rooms.add(cur.end);		
			ans = Math.max(ans, rooms.size());
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
