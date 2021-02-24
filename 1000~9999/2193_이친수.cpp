#include <iostream>
using namespace std;
long long dp[91];

long long result(int n) {
	if (dp[n] == 0) dp[n] = result(n - 1) + result(n - 2);
	return dp[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	dp[1] = dp[2] = 1;
	cout << result(n) << "\n";
	return 0;
}
