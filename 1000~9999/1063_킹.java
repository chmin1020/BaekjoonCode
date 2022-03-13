import java.io.*;
import java.util.*;

class Pair{
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	int x, y;
}

public class Main {
	static boolean[][] chess;
	public static Pair move(String input, Pair pos, Pair stone) {
		if(input.equals("R") && pos.x < 7) {
			if(chess[pos.x + 1][pos.y])
				 move(input, stone, stone);
			if(!chess[pos.x + 1][pos.y]) {
				chess[pos.x][pos.y] = false;
				pos.x++;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("L") && pos.x > 0) {
			if(chess[pos.x - 1][pos.y])
				 move(input, stone, stone);
			if(!chess[pos.x - 1][pos.y]) {
				chess[pos.x][pos.y] = false;
				pos.x--;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("T") && pos.y < 7) {
			if(chess[pos.x][pos.y + 1])
				 move(input, stone, stone);
			if(!chess[pos.x][pos.y + 1]) {
				chess[pos.x][pos.y] = false;
				pos.y++;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("B") && pos.y > 0) {
			if(chess[pos.x][pos.y - 1])
				 move(input, stone, stone);
			if(!chess[pos.x][pos.y - 1]) {
				chess[pos.x][pos.y] = false;
				pos.y--;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("RT") && pos.x < 7 && pos.y < 7) {
			if(chess[pos.x + 1][pos.y + 1])
				 move(input, stone, stone);
			if(!chess[pos.x + 1][pos.y + 1]) {
				chess[pos.x][pos.y] = false;
				pos.x++; pos.y++;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("LT") && pos.x > 0 && pos.y < 7) {
			if(chess[pos.x - 1][pos.y + 1])
				 move(input, stone, stone);
			if(!chess[pos.x - 1][pos.y + 1]) {
				chess[pos.x][pos.y] = false;
				pos.x--; pos.y++;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("RB") && pos.x < 7 && pos.y > 0) {
			if(chess[pos.x + 1][pos.y - 1])
				 move(input, stone, stone);
			if(!chess[pos.x + 1][pos.y - 1]) {
				chess[pos.x][pos.y] = false;
				pos.x++; pos.y--;
				chess[pos.x][pos.y] = true;
			}
		}
		else if(input.equals("LB") && pos.x > 0 && pos.y > 0) {
			if(chess[pos.x - 1][pos.y - 1])
				 move(input, stone, stone);
			if(!chess[pos.x - 1][pos.y - 1]) {
				chess[pos.x][pos.y] = false;
				pos.x--; pos.y--;
				chess[pos.x][pos.y] = true;
			}
		}
		return pos;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String input = st.nextToken();
		Pair king = new Pair(input.charAt(0) - 'A', input.charAt(1) - '1');
		input = st.nextToken();
		Pair stone = new Pair(input.charAt(0) - 'A', input.charAt(1) - '1');
		
		chess = new boolean[8][8];
		chess[king.x][king.y] = true;
		chess[stone.x][stone.y] = true;
		
		int n = Integer.parseInt(st.nextToken());	
		for(int i = 0; i < n; i++) {
			input = br.readLine();
			king = move(input, king, stone);		
		}
		
		bw.write((char)(king.x + 'A') + "" + (char)(king.y + '1') + "\n");
		bw.write((char)(stone.x + 'A') + "" + (char)(stone.y + '1') + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
