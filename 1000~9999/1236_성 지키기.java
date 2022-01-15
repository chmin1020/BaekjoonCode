import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col, row;
		int[] empty = new int[2];
		boolean flag;
		char[][] castle;
		
		Arrays.fill(empty, 0);
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		castle = new char[col][row];
		for(int i = 0; i < col; i++)
			castle[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < col; i++) {
			flag = false;
			for(int j = 0; j < row; j++) {
				if(castle[i][j] == 'X') {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			empty[0]++;
		}
		for(int i = 0; i < row; i++) {
			flag = false;
			for(int j = 0; j < col; j++) {
				if(castle[j][i] == 'X') {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			empty[1]++;
		}
		
		bw.write(Math.max(empty[0],empty[1]) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
