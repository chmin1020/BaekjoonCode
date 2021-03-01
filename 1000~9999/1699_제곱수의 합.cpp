#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int result(int n) {
	vector<int> dp(n + 1, 0);
	for (int i = 1; i <= n; i++) {
		dp[i] = i;
		for (int j = 1; j*j <= i; j++)
			dp[i] = min(dp[i], 1 + dp[i - j*j]);
	}
	return dp[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	cout << result(n) << "\n";
	return 0;
}
