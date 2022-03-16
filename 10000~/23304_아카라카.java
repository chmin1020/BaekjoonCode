import java.io.*;
import java.util.*;

public class Main {
	public static boolean akaCheck(String s, int len) {
		if(len == 1)
			return true;
		
		for(int i = 0; i < len / 2; i++)
			if(s.charAt(i) != s.charAt(len - 1 - i))
				return false;
		
		return akaCheck(s.substring(0, len / 2), len/2) && akaCheck(s.substring((len + 1) / 2), len/2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		if(akaCheck(str, str.length())) bw.write("AKARAKA\n");
		else bw.write("IPSELENTI\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
