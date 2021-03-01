#include <iostream>
#include <algorithm>
using namespace std;
int price[1001], dp[1001];

int result(int n) {
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= i; j++)
			dp[i] = max(dp[i], dp[i - j] + price[j]);
	}
	return dp[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> price[i];
	cout << result(n) << "\n";
	return 0;
}
