#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int result(int n) {
	vector<int> dp(n + 1, 0);
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
		if (i % 2 == 0) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2)
				dp[i] += (dp[j] * 2);
		}
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
