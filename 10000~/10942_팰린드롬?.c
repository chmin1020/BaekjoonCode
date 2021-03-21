#include <stdio.h>
#include <stdlib.h>

void decide(int n, int m, int* seq) {
	int s, e, **dp;

	dp = (int**)malloc(sizeof(int*)*(n + 1));
	for (int i = 0; i <= n; i++)
		dp[i] = (int*)malloc(sizeof(int)*(n + 1));

	for (int i = 1; i <= n; i++) dp[i][i] = 1;
	for (int i = 1; i < n; i++) dp[i][i + 1] = (seq[i] == seq[i + 1]) ? 1 : 0;
	for (int i = 2; i < n; i++) // i = gap
		for (int j = 1; j <= n - i; j++) 
			dp[j][i + j] = (seq[j] == seq[i + j] && dp[j + 1][i + j - 1]) ? 1 : 0;

	for (int i = 0; i < m; i++) { //판별
		scanf("%d %d", &s, &e);
		printf("%d\n", dp[s][e]);
	}
	for (int i = 0; i <= n; i++) free(dp[i]);
	free(dp);
}
int main() {
	int n, m, *seq;
	
	scanf("%d", &n);
	seq = (int*)malloc(sizeof(int)*(n+1));
	seq[0] = 0;
	for (int i = 1; i <= n; i++)
		scanf("%d", &seq[i]);
	scanf("%d", &m);
	decide(n, m, seq);
	free(seq);
	return 0;
}
