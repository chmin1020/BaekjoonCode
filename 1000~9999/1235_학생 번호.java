import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int student_num = Integer.parseInt(br.readLine());
		int idLen;
		int len = 1;
		
		ArrayList<String> ids = new ArrayList<String>();
		Set<String> redundantCheck = new HashSet<String>();
		
		for(int i = 0; i < student_num; i++)
			ids.add(br.readLine());
		
		idLen = ids.get(0).length();
		
		while(true) {
			redundantCheck.clear();
			
			for(int i = 0; i < student_num; i++) 
				redundantCheck.add(ids.get(i).substring(idLen - len, idLen));
			
			if(redundantCheck.size() == student_num)
				break;
			len++;
		}
		
		bw.write(len + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
