import java.io.*;
import java.math.BigInteger;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String first = br.readLine();
		String result;
		
		BigInteger test = new BigInteger(first);
		BigInteger NINE = new BigInteger("9");
		boolean isAllNine = true;
		
		while(test.compareTo(BigInteger.ZERO) != 0) {
			if(test.mod(BigInteger.TEN).compareTo(NINE) != 0) {
				isAllNine = false;
				break;
			}
			test = test.divide(BigInteger.TEN);
		}
		
		if(isAllNine)
			result = (new BigInteger(first)).add(BigInteger.TWO).toString();
		else {
			String left = first.substring(0, first.length() / 2);
			if(first.length() % 2 == 1) {
				String mid = first.substring(first.length() / 2, first.length() / 2 + 1);
						
				while(true) {
					result = left + mid + numReverse(left);
					
					if(result.compareTo(first) > 0)
						break;
					
					
					mid = increaseNum(mid);
					if(mid.equals("10")) {
						mid = "0";
						left = increaseNum(left);
					}
				}	
			}
			else {
				while(true) {		
					result = left + numReverse(left);
					
					if(result.compareTo(first) > 0)
						break;
					
					left = increaseNum(left);	
				}
			}
		}
		bw.write(result);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static String increaseNum(String num) {
		BigInteger byInt = new BigInteger(num);
		byInt = byInt.add(BigInteger.ONE);
		return byInt.toString();
	}
	
	private static String numReverse(String num) {
		StringBuffer sb = new StringBuffer(num);
		return sb.reverse().toString();
	}
}
