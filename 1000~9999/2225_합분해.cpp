#include <iostream>
#define MOD 1000000000
using namespace std;
long long dp[201][201];

long long result(int n, int k) {
	for (int i = 0; i <= k; i++) dp[0][i] = 1;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= k; j++)
			dp[i][j] = ((dp[i - 1][j] % MOD) + (dp[i][j - 1] % MOD)) % MOD;
	return dp[n][k];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, k;

	cin >> n >> k;
	cout << result(n, k) << "\n";
	return 0;
}
