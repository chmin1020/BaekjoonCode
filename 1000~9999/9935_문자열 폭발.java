import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> result = new Stack<Character>();
		Stack<Character> test = new Stack<Character>();
		String input = br.readLine();
		String bomb = br.readLine();
		
		for(int i = input.length() - 1; i >= 0; i--) {
			result.push(input.charAt(i));
			if(input.charAt(i) == bomb.charAt(0)) {
				for(int j = 0; j < bomb.length(); j++){
					if(result.isEmpty() || result.peek() != bomb.charAt(j)) {
						while(!test.isEmpty()) {
							result.push(test.pop());
						}
						break;
					}
					else
						test.push(result.pop());
				}
				test.clear();
			}
		}
		if(result.isEmpty())
			bw.write("FRULA\n");
		else {
			while(!result.isEmpty())
				bw.write(result.pop());
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
