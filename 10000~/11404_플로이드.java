package realSpace;
import java.util.Scanner;

class Line{
	public int start, end, cost;

	Line(int s, int e, int c){
		start = s;
		end = e;
		cost = c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		int start, end, cost;
		int[][] list = new int[101][101];
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j)
					list[i][j] = 0;
				else
					list[i][j] = 50000000;
			}
		}
		
		for(int i = 0; i < m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			cost = sc.nextInt();
			
			if(list[start][end] > cost)
				list[start][end] = cost;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= n; k++) {
					if(list[j][k] > list[j][i] + list[i][k])
						list[j][k] = list[j][i] + list[i][k];
				}
			}
		}
				
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(list[i][j] == 50000000)
						list[i][j] = 0;
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
				
		sc.close();
	}
}
