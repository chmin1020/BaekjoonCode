import java.io.*;
import java.util.*;

public class Main {
	private static int W, H, f, c, x1, y1, x2, y2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		long rightLen = W - f;
		long xRange = 0, xExtra = 0;
		long yRange = y2 - y1;
		
		xRange = x2 - x1;
		if (f < rightLen && x1 < f) {
			if(x2 < f)
				xExtra = x2 - x1;
			else
				xExtra = f - x1;
		}
		else if(f >= rightLen && x1 < rightLen) {
			if(x2 < rightLen)
				xExtra = x2 - x1;
			else
				xExtra = rightLen - x1;
		}
		
		long answer = (long)W * (long)H - (xRange + xExtra) * yRange * (c + 1);
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
