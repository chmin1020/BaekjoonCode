import java.util.Scanner;
import java.util.PriorityQueue;

class Pos implements Comparable<Pos>{
	public int x,y, dis;
	Pos(int x, int y, int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
	
	public int compareTo(Pos o) {
		return this.dis >= o.dis ? 1:-1;
	}
}

public class Main {
	private static int n, m;
	private static String tmp;
	private static int[][] maze = new int[100][100];
	private static int[][] route = new int[100][100];
	private static boolean[][] isChecked = new boolean[100][100];
	
	public static void dijkstra() {
		PriorityQueue<Pos> heap = new PriorityQueue<>();
		Pos cur = null;
		
		heap.offer(new Pos(0,0,0));	
		route[0][0] = 0;
		
		while(!heap.isEmpty()) {
			cur = heap.poll();
			if(isChecked[cur.x][cur.y]) continue;
			isChecked[cur.x][cur.y] = true;
			
			if(cur.x - 1 >= 0 && !isChecked[cur.x - 1][cur.y]) {
				if(route[cur.x - 1][cur.y] > route[cur.x][cur.y] + maze[cur.x - 1][cur.y])
					route[cur.x - 1][cur.y] = route[cur.x][cur.y] + maze[cur.x - 1][cur.y];
				heap.offer(new Pos(cur.x - 1, cur.y, route[cur.x - 1][cur.y]));
			}		
			if(cur.x + 1 < m && !isChecked[cur.x + 1][cur.y]) {
				if(route[cur.x + 1][cur.y] > route[cur.x][cur.y] + maze[cur.x + 1][cur.y])
					route[cur.x + 1][cur.y] = route[cur.x][cur.y] + maze[cur.x + 1][cur.y];
				heap.offer(new Pos(cur.x + 1, cur.y, route[cur.x + 1][cur.y]));
			}
			if(cur.y - 1 >= 0 && !isChecked[cur.x][cur.y - 1]) {
				if(route[cur.x][cur.y - 1] > route[cur.x][cur.y] + maze[cur.x][cur.y - 1])
					route[cur.x][cur.y - 1] = route[cur.x][cur.y] + maze[cur.x][cur.y - 1];
				heap.offer(new Pos(cur.x, cur.y - 1, route[cur.x][cur.y - 1]));
			}		
			if(cur.y + 1 < n && !isChecked[cur.x][cur.y + 1]) {
				if(route[cur.x][cur.y + 1] > route[cur.x][cur.y] + maze[cur.x][cur.y + 1])
					route[cur.x][cur.y + 1] = route[cur.x][cur.y] + maze[cur.x][cur.y + 1];
				heap.offer(new Pos(cur.x, cur.y + 1, route[cur.x][cur.y + 1]));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			tmp = sc.next();
			for(int j = 0; j < n; j++) {
				maze[i][j] = Integer.parseInt(Character.toString(tmp.charAt(j)), 10);
				route[i][j] = 10000;
				isChecked[i][j] = false;
			}
		}
		
		dijkstra();
		
		System.out.println(route[m - 1][n - 1]);
		sc.close();
	}
}
