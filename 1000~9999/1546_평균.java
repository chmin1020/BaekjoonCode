import java.io.*;

public class Main {
	public static void main(String[] args) {
		int len;
		String get;
		String st[];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			len = Integer.parseInt(in.readLine());	
			get = in.readLine();
			st = get.split(" ");
			double[] data = new double[len];
			
			data[0] = Integer.parseInt(st[0]);
			double max = data[0];
			for(int i = 1; i < len; i++){
				data[i] = Integer.parseInt(st[i]);
				if(data[i] > max)
					max = data[i];
			}
			double sum = 0;
			for(int i = 0; i < len; i++){
				data[i] = data[i]/max * 100;
				sum += data[i];
			}		
			System.out.printf("%.2f\n",sum/len);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
