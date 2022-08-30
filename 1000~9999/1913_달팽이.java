import java.io.*;

public class Main {	
	public static int[] xDirect = { -1, 0, 1, 0};
	public static int[] yDirect = { 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int tar = Integer.parseInt(br.readLine());
		int ansX = 0, ansY = 0;
		
		int[][] snail = new int[n][n];
		
		int curX = n / 2, curY = n / 2;
		int curDirect = 0;
		int curLimit = 1;
		int curLimitCnt = 0;
		int curCnt = 0;
		int curNum = 1;
		
		snail[curX][curY] = curNum++;
		while(curNum <= n * n) {
			curX += xDirect[curDirect];
			curY += yDirect[curDirect];
		
			snail[curX][curY] = curNum++;
			
			curCnt++;
			if(curLimit == curCnt) {
				curLimitCnt++;
				curCnt = 0;
				curDirect = (curDirect + 1) % 4;	
			}
			
			if(curLimitCnt == 2) {
				curLimitCnt = 0;
				curLimit++;
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				bw.write(snail[i][j] + " ");
				
				if(snail[i][j]  == tar) {
					ansX = i + 1;
					ansY = j + 1;
				}
			}
			bw.write("\n");
		}
		
		bw.write(ansX + " " + ansY + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
