#include <iostream>
using namespace std;
int dp[1001][10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, sum = 0;

	cin >> n;
	for (int i = 0; i < 10; i++) dp[1][i] = 1;
	for (int i = 2; i <= n; i++) {
		dp[i][0] = 1;
		for (int j = 1; j < 10; j++)
			dp[i][j] = ((dp[i - 1][j] % 10007) + (dp[i][j - 1] % 10007)) % 10007;
	}
	for (int i = 0; i < 10; i++) {
		sum += dp[n][i];
	}
	cout << sum%10007 << "\n";
	return 0;
}
