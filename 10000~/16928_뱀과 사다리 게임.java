package realSpace;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] ladderOrSnake = new int[101];
		int[] diceN = new int[101];
		int n, m, start, end, cur;
		
		for(int i = 1; i <= 100; i++) {
			diceN[i] = -1;
			ladderOrSnake[i] = -1;
		}
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < n + m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			ladderOrSnake[start] = end;
		}
		
		queue.add(1);
		diceN[1] = 0;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(cur == 100) break;
				
			for(int i = 1; i <= 6; i++) {
				if(cur + i > 100 || diceN[cur + i] != -1) continue;
				
				if(ladderOrSnake[cur + i] != -1) {
					if(diceN[ladderOrSnake[cur + i]] == -1) {
						diceN[ladderOrSnake[cur + i]] = diceN[cur] + 1;
						queue.add(ladderOrSnake[cur + i]);
					}
				}
				else {
					diceN[cur + i] = diceN[cur] + 1;
					queue.add(cur + i);	
				}
			}
		}
		System.out.println(diceN[100]);
		sc.close();
	}
}
