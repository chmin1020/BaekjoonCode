#include<iostream>

#define min(x,y) (x) < (y) && (x) != 0 && (y) != 0 ? (x) : (y)

int DP[1000001] = { 0 };

int main()
{
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		if (i + 1 <= n)DP[i + 1] = min(DP[i + 1], DP[i] + 1);
		if (i * 2 <= n) {
			DP[i * 2] = min(DP[i * 2], DP[i] + 1);
		}
		if (i * 3 <= n) {
			DP[i * 3] = min(DP[i * 3], DP[i] + 1);
		}
	}
	printf("%d\n", DP[n]);
	return 0;
}
