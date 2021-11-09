package realSpace;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> culArr = new ArrayList<Long>();
		int n, m, start, end;
		long tmp;
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		culArr.add((long) 0);
		for(int i = 1; i <= n; i++) {
			tmp = sc.nextLong();
			culArr.add(culArr.get(i - 1) + tmp);
		}
		
		for(int i = 0; i < m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();	
			System.out.println(culArr.get(end) - culArr.get(start - 1));
		}
		sc.close();
	}
}
