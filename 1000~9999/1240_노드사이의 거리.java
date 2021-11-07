package realSpace;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] distance = new int[1001][1001];
		int n, m, tpx, tpy;
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) distance[i][j] = 0;
				else distance[i][j] = 10000000;
			}
		}
		
		for(int i = 0; i < n - 1; i++) {
			tpx = sc.nextInt();
			tpy = sc.nextInt();
			distance[tpx][tpy] = sc.nextInt();
			distance[tpy][tpx] = distance[tpx][tpy];
		}
		
		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= n; j++) 
				for(int k = 1; k <= n; k++) 
					if(distance[j][k] > distance[j][i] + distance[i][k])
						distance[j][k] = distance[j][i] + distance[i][k];

		for(int i = 0; i < m; i++) {
			tpx = sc.nextInt();
			tpy = sc.nextInt();
			System.out.println(distance[tpx][tpy]);
		}
		
		sc.close();
	}
}
