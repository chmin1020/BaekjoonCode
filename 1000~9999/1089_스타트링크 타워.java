package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num;
		long allSum = 0, mulVal;
		double answer;
		String[] input = new String[5];
		String[] criteria = new String[5];
		boolean[][] possible = new boolean[10][10];
		int[] possibleNum = new int[10];
		long[] carryArr = new long[10]; 
		
		criteria[0] = "###...#.###.###.#.#.###.###.###.###.###";
		criteria[1] = "#.#...#...#...#.#.#.#...#.....#.#.#.#.#";
		criteria[2] = "#.#...#.###.###.###.###.###...#.###.###";
		criteria[3] = "#.#...#.#.....#...#...#.#.#...#.#.#...#";
		criteria[4] = "###...#.###.###...#.###.###...#.###.###";
		
		num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++)
			Arrays.fill(possible[i], true);
		Arrays.fill(possibleNum, 10);
		Arrays.fill(carryArr, 0);
		
		for(int i = 0; i < 5; i++)
			input[i] = br.readLine();
		
		for(int i = 0; i < num; i++) {
			for(int j = i * 4; j < i * 4 + 3; j++) {
				for(int k = 0; k < 5; k++) {
					for(int l = 0; l < 10; l++) {
						if(input[k].charAt(j) == '#' && criteria[k].charAt((l*4) + (j - i*4)) == '.') {
							if(possible[i][l]) {
								possible[i][l] = false;
								possibleNum[i]--;
							}
						}
					}
				}
			}
		}
		
		mulVal = 1;
		for(int i = 0; i < num; i++)
			mulVal *= possibleNum[i];
		for(int i = num - 1; i >= 0; i--) {
			for(int j = 0; j < 10; j++)
				if(possible[i][j]) carryArr[i] += j;
			if(possibleNum[i] > 0)
				carryArr[i] *= (mulVal / possibleNum[i]);
		}
		for(int i = num - 1; i >= 0; i--) {
			if(i > 0) {
				carryArr[i - 1] += carryArr[i] / 10;
				carryArr[i] %= 10;
			}
			allSum += Math.pow(10, num - 1 - i) * carryArr[i];
		}
		
		answer = mulVal > 0 ? (double)allSum/mulVal : -1;
		bw.write(Double.toString(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
