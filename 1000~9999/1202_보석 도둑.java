package realSpace;
import java.io.*;
import java.util.*;

public class Main {
	static class Info implements Comparable<Info>{
		public int weight, price;
		Info(int w, int p){
			weight = w;
			price = p;
		}
		public int compareTo(Info o) {
			return o.weight < this.weight ? 1 : -1;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> bags = new PriorityQueue<Integer>();
		PriorityQueue<Integer> possible = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Info> info = new ArrayList<Info>();
		String[] input= new String[2];
		int n, m;
		long result = 0;
		
		try {
			input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
		
			for(int i = 0; i < n; i++) {
				input = br.readLine().split(" ");
				info.add(new Info(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
			}			
			Collections.sort(info);
			
			for(int i = 0; i < m; i++) {
				input[0] = br.readLine();
				bags.offer(Integer.parseInt(input[0]));
			}
			
			int curBag, curJewelPtr = 0;
			while(!bags.isEmpty()) {
				curBag = bags.poll();
				
				while(curJewelPtr < info.size() && curBag >= info.get(curJewelPtr).weight) 
					possible.offer(info.get(curJewelPtr++).price);
				
				if(possible.isEmpty()) continue;
				result += possible.poll();
			}
			bw.write(Long.toString(result));
			bw.flush();
			bw.close();
		} 
		catch (IOException e) {}
	}
}
