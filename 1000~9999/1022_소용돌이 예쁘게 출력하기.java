import java.io.*;
import java.util.*;

public class Main {
	private static int r1, c1, r2, c2;
	private static int[][] answerMap;
	
	private static int[] directX = {0, -1, 0, 1};
	private static int[] directY = {1, 0, -1, 0};
	private static int cellCnt;
	private static int maxN = -1;

	private static int getDigit(int n) {
		int ans = 0;
		
		while(n != 0) {
			n /= 10;
			ans++;
		}

		return ans;
	}
	
	private static void fillMap(int x, int y, int n) {
		if((r1 <= x && r2 >= x) && (c1 <= y && c2 >= y)) {
			answerMap[x - r1][y - c1] = n;
			maxN = Math.max(maxN, n);
			cellCnt--;
		}
	}
	
	private static void drawVortex() {
		int curX = 0, curY = 0;
		int limit = 1;
		int cntTwo = 0;
		int direct = 0;
		int going = 0;
		int num = 1;
		
		fillMap(curX, curY, num);
		
		while(cellCnt > 0) {
			num++;
			going++;
			curX += directX[direct];
			curY += directY[direct];
			
			fillMap(curX, curY, num);			
			
			if(going == limit) {
				cntTwo++;
				going = 0;
				direct = (direct + 1) % 4;
			}
			
			if(cntTwo == 2) {
				limit++;
				cntTwo = 0;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		answerMap = new int[r2 - r1 + 1][c2- c1 + 1];
		cellCnt = (r2 - r1 + 1) * (c2 - c1 + 1);
		
		drawVortex();
		
		maxN = getDigit(maxN);
		
		
		for(int i = 0; i < (r2 - r1 + 1); i++) {
			for(int j = 0; j < (c2 - c1 + 1); j++) {
				int blankCnt = maxN - getDigit(answerMap[i][j]);
				for(int k = 0; k < blankCnt; k++)
					bw.write(" ");		
				bw.write(answerMap[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
