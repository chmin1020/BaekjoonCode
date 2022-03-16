import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int len = input.length();
		boolean isIn = false;
		
		for(int i = 0; i < len - 1;) {
			if(input.charAt(i) == 'D' || input.charAt(i) == 'd') {
				if(input.charAt(i + 1) == '2') {
					isIn = true;
					break;
				}
			}
			if(input.charAt(i + 1) == 'D' || input.charAt(i + 1) == 'd')
				i++;
			else
				i+=2;
		}
		
		if(isIn) bw.write("D2\n");
		else bw.write("unrated\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
