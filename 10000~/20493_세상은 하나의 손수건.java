import java.io.*;
import java.util.*;

public class Main {
	static int x = 0, y = 0, curS = 0;
	
	public static void forward(int until, int direct) {
		for(; curS < until; curS++) {
			if(direct == 0)
				x++;
			else if(direct == 1)
				y--;
			else if(direct == 2)
				x--;
			else if(direct == 3)
				y++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int change, step, at, curD = 0;
		String lor;
		
		st = new StringTokenizer(br.readLine());
		change = Integer.parseInt(st.nextToken());
		step = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < change; i++) {
			st = new StringTokenizer(br.readLine());
			at = Integer.parseInt(st.nextToken());
			lor = st.nextToken();
			
			forward(at, curD);
			if(lor.equals("left"))
				curD -= 1;
			else
				curD += 1;
			if(curD == -1)
				curD = 3;
			curD %= 4;	
		}
		forward(step, curD);
		
		bw.write(x + " " + y + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
