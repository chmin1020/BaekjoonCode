import java.io.*;
import java.util.*;

public class Main {	

	static class Dot{
		int x, y;
		Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static double calculateArea(Dot dot1, Dot dot2, Dot dot3) {
		int front = (dot1.x * dot2.y + dot2.x * dot3.y + dot3.x * dot1.y);
		int back  = (dot2.x * dot1.y + dot3.x * dot2.y + dot1.x * dot3.y);
		return Math.abs(front - back) / 2.0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		double answer = 0;
		
		int dotNum = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[dotNum];
		
		for(int i = 0; i < dotNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			dots[i] = new Dot(x, y);
		}
		
		for(int i = 0; i < dotNum; i++) 
			for(int j = i + 1; j < dotNum; j++) 
				for(int k = j + 1; k < dotNum; k++) 
					answer = Math.max(answer, calculateArea(dots[i], dots[j], dots[k]));

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
