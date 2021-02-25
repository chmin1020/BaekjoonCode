#include <iostream>
#include <algorithm>
using namespace std;
int dp[2][100001], sticker[2][100001];

int result(int n) {
	dp[0][0] = dp[1][0] = 0;
	dp[0][1] = sticker[0][1]; dp[1][1] = sticker[1][1];
	for (int i = 2; i <= n; i++) {
		dp[0][i] = max(dp[1][i - 2] + sticker[0][i], dp[1][i - 1] + sticker[0][i]);
		dp[1][i] = max(dp[0][i - 2] + sticker[1][i], dp[0][i - 1] + sticker[1][i]);
	}
	return max(dp[0][n], dp[1][n]);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, n;

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> n;
		for (int j = 0; j < 2; j++)
			for (int k = 1; k <= n; k++)
				cin >> sticker[j][k];
		cout << result(n) << "\n";
	}
	return 0;
}
