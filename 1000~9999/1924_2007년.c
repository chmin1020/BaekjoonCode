#include <stdio.h>

int main() {
	int month, day, re = 0;
	char* week[7] = { "SUN","MON","TUE","WED","THU","FRI","SAT" };
	int dayCnt[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };

	scanf("%d %d", &month, &day);
	for (int i = 1; i < month; i++)
		re += dayCnt[i-1];
	re = (re + day) % 7;
	printf("%s\n", week[re]);
	return 0;
}
