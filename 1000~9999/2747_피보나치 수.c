#include <stdio.h>
#include <string.h>
int dp[46];

int fibonacci(int num) {
	if (num != 0 && dp[num] == 0)
		dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
	return dp[num];
}

int main() {
	int n;
	memset(dp, 0, sizeof(dp));
	dp[0] = 0, dp[1] = 1;

	scanf("%d", &n);
	printf("%d\n", fibonacci(n));
	return 0;
}
