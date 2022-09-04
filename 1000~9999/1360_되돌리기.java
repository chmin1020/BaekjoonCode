import java.io.*;
import java.util.*;

public class Main {
	static class Order{
		boolean isType;
		int value, time;
		
		Order(boolean it, int v, int t){
			isType = it;
			value = v;
			time = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int num = Integer.parseInt(br.readLine());
		Stack<Order> making = new Stack<Order>();
		
		String[] commands;
		for(int i = 0; i < num; i++) {
			commands = br.readLine().split(" ");
			
			if(commands[0].equals("type")) 
				making.add(new Order(true, commands[1].charAt(0), Integer.parseInt(commands[2])));
			else 
				making.add(new Order(false, Integer.parseInt(commands[1]), Integer.parseInt(commands[2])));
		}

		String result = ""; 
		while(!making.isEmpty()) {
			Order cur = making.pop();

			if(cur.isType)
				result += (char)cur.value;
			else {
				int deleteStart = cur.time - cur.value;
				
				while(!making.isEmpty() && making.peek().time >= deleteStart)
					making.pop();
			}			
		}
				
		for(int i = result.length() - 1; i >= 0; i--)
			bw.write(result.charAt(i));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
