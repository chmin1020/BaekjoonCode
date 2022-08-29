import java.io.*;

public class Main {
	static int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static boolean isLeapYear(int year) {
		if(year % 4 == 0) {
			if(year % 100 == 0 && year % 400 != 0)
				return false;
			return true;
		}
		return false;
	}
	
	public static int getDaysInMonth(int year, int month) {
		if(month == 2 && isLeapYear(year))
			return 29;
		return months[month];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] date1 = br.readLine().split(" ");
		String[] date2 = br.readLine().split(" ");			
		
		int today_year = Integer.parseInt(date1[0]);
		int end_year = Integer.parseInt(date2[0]);
		int today_month = Integer.parseInt(date1[1]);
		int end_month = Integer.parseInt(date2[1]);
		int today_day = Integer.parseInt(date1[2]);
		int end_day = Integer.parseInt(date2[2]);		
		
		if((end_year - today_year > 1000) || 
		   (end_year - today_year == 1000 && end_month > today_month) ||
		   (end_year - today_year == 1000 && end_month == today_month && end_day >= today_day))
			bw.write("gg");
		else {
			int answer = 0;
			
			if(today_year != end_year) {
				answer += (getDaysInMonth(today_year, today_month) - today_day);
				for(int month = today_month + 1; month <= 12; month++) 
					answer += getDaysInMonth(today_year, month);
				
				for(int year = today_year + 1; year < end_year; year++) {
					answer += 365;
					if(isLeapYear(year))
						answer += 1;
				}
				
				for(int month = 1; month < end_month; month++)
					answer += getDaysInMonth(end_year, month);
				
				answer += end_day;				
			}
			else {
				if(today_month != end_month) {
					answer += (getDaysInMonth(today_year, today_month) - today_day);
					for(int month = today_month + 1; month < end_month; month++) 
						answer += getDaysInMonth(today_year, month);
					answer += end_day;
				}
				else
					answer += (end_day - today_day);
			}
			
			bw.write("D-" + answer);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
