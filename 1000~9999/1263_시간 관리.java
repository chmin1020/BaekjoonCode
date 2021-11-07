package realSpace;
import java.util.Scanner;
import java.util.PriorityQueue;

class Schedule implements Comparable<Schedule>{
	public int slice, deadline;

	Schedule(int s, int d){
		slice = s;
		deadline = d;
	}
	public int compareTo(Schedule o) {
		if(this.deadline == o.deadline)
			return this.slice > o.slice ? 1 : -1;
		return this.deadline > o.deadline ? 1 : - 1;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Schedule> heap = new PriorityQueue<Schedule>();
		int n, sl,dl, cur = 0, answer = 10000000;
		Schedule now = null;
		
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			sl = sc.nextInt();
			dl = sc.nextInt();
			heap.offer(new Schedule(sl, dl));
		}
		
		while(!heap.isEmpty()) {
			now = heap.poll();
			cur += now.slice;

			if(now.deadline - cur < 0) {
				answer = -1;
				break;
			}
			if(answer > now.deadline - cur)
				answer = now.deadline - cur;	
		}
		if(cur > 1000000) answer = -1;
		
		System.out.println(answer);
		sc.close();
	}
}
