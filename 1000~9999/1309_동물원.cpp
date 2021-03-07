#include <iostream>
#define MOD 9901
using namespace std;

int result(int n) {
	int dp[100001];
	dp[1] = 3; dp[2] = 7;

	for (int i = 3; i <= n; i++)
		dp[i] = (dp[i - 2] + dp[i - 1] * 2) % MOD;
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
