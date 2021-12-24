import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int reward = Integer.parseInt(br.readLine());
		
		bw.write((reward * 78) / 100 + " " + ((reward * 80) / 100 + ((reward * 20 /100) * 78 / 100)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
