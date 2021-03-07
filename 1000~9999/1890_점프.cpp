#include <iostream>
#include <cstring>
using namespace std;
unsigned long long map[101][101];

unsigned long long result(int n) {
	unsigned long long dp[101][101];
	memset(dp, 0, sizeof(dp));
	dp[1][1] = 1;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (map[i][j] == 0) continue;
			if (i + map[i][j] <= n) dp[i + map[i][j]][j] += dp[i][j];
			if (j + map[i][j] <= n) dp[i][j + map[i][j]] += dp[i][j];
		}
	}
	return dp[n][n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= n; j++)
			cin >> map[i][j];
	cout << result(n) << "\n";
	return 0;
}
