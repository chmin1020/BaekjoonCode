import java.io.*;
import java.util.*;

public class Main {	
	static int[][] map = new int[50][50];
	static int[][] tmpMap = new int[50][50];
	static ArrayList<Pair> airClean = new ArrayList<Pair>();
	static int result = 0, r, c;
	
	static class Pair{
		public int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void dust() {
		int quan = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] >= 5) {
					quan = map[i][j] / 5;			
					if(i - 1 >= 0 && map[i - 1][j] != -1) {
						tmpMap[i - 1][j] += quan;
						map[i][j] -= quan;
					}
					if(i + 1 < r && map[i + 1][j] != -1) {
						tmpMap[i + 1][j] += quan;
						map[i][j] -= quan;
					}
					if(j - 1 >= 0 && map[i][j - 1] != -1) {
						tmpMap[i][j - 1] += quan;
						map[i][j] -= quan;
					}
					if(j + 1 < c && map[i][j + 1] != -1) {
						tmpMap[i][j + 1] += quan;
						map[i][j] -= quan;
					}
				}
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] += tmpMap[i][j];
				tmpMap[i][j] = 0;
			}
		}
	}
	
	static void clean() {
		int tmp, swap;
		//up
		tmp = 0;
		for(int i = airClean.get(0).y + 1; i < c; i++) {
			swap = tmp;
			tmp = map[airClean.get(0).x][i];
			map[airClean.get(0).x][i] = swap;
		}
		for(int i = airClean.get(0).x - 1; i >= 0; i--) {
			swap = tmp;
			tmp = map[i][c - 1];
			map[i][c - 1] = swap;
		}
		for(int i = c - 2; i >= airClean.get(0).y; i--) {
			swap = tmp;
			tmp = map[0][i];
			map[0][i] = swap;
		}
		for(int i = 1; i < airClean.get(0).x; i++) {
			swap = tmp;
			tmp = map[i][airClean.get(0).y];
			map[i][airClean.get(0).y] = swap;
		}
		result -= tmp;
		
		//down
		tmp = 0;
		for(int i = airClean.get(1).y + 1; i < c; i++) {
			swap = tmp;
			tmp = map[airClean.get(1).x][i];
			map[airClean.get(1).x][i] = swap;
		}
		for(int i = airClean.get(1).x + 1; i < r; i++) {
			swap = tmp;
			tmp = map[i][c - 1];
			map[i][c - 1] = swap;
		}
		for(int i = c - 2; i >= airClean.get(1).y; i--) {
			swap = tmp;
			tmp = map[r - 1][i];
			map[r - 1][i] = swap;
		}
		for(int i = r - 2; i > airClean.get(1).x; i--) {
			swap = tmp;
			tmp = map[i][airClean.get(1).y];
			map[i][airClean.get(1).y] = swap;
		}
		result -= tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[200];
		int t;
		
		input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		t = Integer.parseInt(input[2]);
		
		for(int i = 0; i < r; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] == -1)
					airClean.add(new Pair(i, j));
				else
					result += map[i][j];
			}
			Arrays.fill(tmpMap[i], 0);
		}	
		
		for(int i = 0; i < t; i++) {
			dust();
			clean();
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
