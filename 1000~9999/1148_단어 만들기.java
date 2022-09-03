import java.io.*;
import java.util.*;

public class Main {
	static class Word{
		int[] alphabets;
		
		Word(String word){
			alphabets = new int[26];
			Arrays.fill(alphabets, 0);
			
			for(int i = 0; i < word.length(); i++) 
				alphabets[word.charAt(i) - 'A']++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Word> dict = new ArrayList<Word>();
		Word puzzle;
		
		String input = br.readLine();
		while(!input.equals("-")){
			dict.add(new Word(input));
			input = br.readLine();
		}
		
		input = br.readLine();
		while(!input.equals("#")) {
			puzzle = new Word(input);
			
			int max = -1, min = 1000000;
			ArrayList<Character> maxChs = new ArrayList<Character>();
			ArrayList<Character> minChs = new ArrayList<Character>();
			int[] result = new int[9];
			
			Arrays.fill(result, 0);
			
			int alpha;
			for(int i = 0; i < 9; i++) {
				alpha = input.charAt(i) - 'A';
				for(int j = 0; j < dict.size(); j++) {
					Word each = dict.get(j);
					
					if(each.alphabets[alpha] == 0)
						continue;
					
					boolean isPossible = true;
					for(int k = 0; k < 26; k++) {
						if(puzzle.alphabets[k] < each.alphabets[k]) {
							isPossible = false;
							break;
						}
					}
					
					if(isPossible) 
						result[i]++;
				}
				
				max = Math.max(max, result[i]);
				min = Math.min(min, result[i]);
			}
			
			
			for(int i = 0; i < 9; i++) {
				if(result[i] == min && !minChs.contains(input.charAt(i)))
					minChs.add(input.charAt(i));
				if(result[i] == max && !maxChs.contains(input.charAt(i)))
					maxChs.add(input.charAt(i));
			}
			Collections.sort(minChs);
			Collections.sort(maxChs);
			
			for(int i = 0; i < minChs.size(); i++)
				bw.write(minChs.get(i));
			bw.write(" " + min + " ");
			
			for(int i = 0; i < maxChs.size(); i++)
				bw.write(maxChs.get(i));
			bw.write(" " + max + "\n");	
			
			input = br.readLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
