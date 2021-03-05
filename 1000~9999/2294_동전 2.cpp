#include <iostream>
#include <algorithm>
using namespace std;
int coin[101];

int result(int n, int k) {
	int dp[10001];
	fill_n(dp, 10001, 100000);
	dp[0] = 0;

	for (int i = 1; i <= n; i++)
		for (int j = coin[i]; j <= k; j++)
			dp[j] = min(dp[j], dp[j - coin[i]] + 1);
	if (dp[k] >= 100000) dp[k] = -1;
	return dp[k];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, k;

	cin >> n >> k;
	for (int i = 1; i <= n; i++)
		cin >> coin[i];
	cout << result(n, k) << "\n";
	return 0;
}
