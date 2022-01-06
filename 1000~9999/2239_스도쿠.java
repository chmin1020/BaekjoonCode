import java.io.*;
import java.util.*;
	
public class Main {
	private static int[][] sdoku = new int[9][9];
	private static ArrayList<Pos> blanks = new ArrayList<Pos>(); 
	static class Pos{
		public int x,y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean backtracking(int index) {
		if(index >= blanks.size()) return true;
		boolean chkFlag, goodFlag = false;
		int tmpX, tmpY;
		
		for(int i = 1; i <= 9; i++) {
			goodFlag = false;
			chkFlag = false;	
			sdoku[blanks.get(index).x][blanks.get(index).y] = i;
				
			for(int j = 0; j < 9; j++) {
				if(blanks.get(index).x == j) continue;
				if(i == sdoku[j][blanks.get(index).y]) {
					chkFlag = true;
					break;
				}
			}
			if(chkFlag) continue;
			
			for(int j = 0; j < 9; j++) {
				if(blanks.get(index).y == j) continue;
				if(i == sdoku[blanks.get(index).x][j]) {
					chkFlag = true;
					break;
				}
			}
			if(chkFlag) continue;
				
			tmpX = (blanks.get(index).x / 3) * 3;
			tmpY = (blanks.get(index).y / 3) * 3;
			for(int j = tmpX; j <= tmpX + 2; j++) {
				for(int k = tmpY; k <= tmpY + 2; k++) {
					if(blanks.get(index).x == j && blanks.get(index).y == k) 
						continue;
					if(i == sdoku[j][k]) {
						chkFlag = true;
						break;
					}
				}
			}
			if(chkFlag) continue;
			
			if(backtracking(index + 1)) {
				goodFlag = true;
				break;
			}
		}	
		if(goodFlag) return true;
		sdoku[blanks.get(index).x][blanks.get(index).y] = 0;
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;
		int line;
		
		for(int i = 0; i < 9; i++) {
			line = Integer.parseInt(br.readLine());
			for(int j = 8; j >= 0; j--) { 
				sdoku[i][j] = line % 10;
				line /= 10;
			}
			
			for(int j = 0; j < 9; j++)
				if(sdoku[i][j] == 0)
					blanks.add(new Pos(i,j));
		}
		backtracking(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) 
				bw.write(String.valueOf(sdoku[i][j]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
