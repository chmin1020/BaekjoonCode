#include <iostream>
#include <algorithm>
using namespace std;
int dp[17];
pair<int, int> info[17]; //time, pay

int result(int n) {
	int tmp, ans = 0;
	for (int i = 1; i <= n + 1; i++) {
		tmp = 0;
		for (int j = 1; j < i; j++) {
			if (j + info[j].first == i)
				dp[i] = max(dp[i], info[j].second + dp[j]);
			if (tmp < dp[j]) tmp = dp[j];
		}
		dp[i] = max(dp[i], tmp);
	}
	return dp[n + 1];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 1; i <= n; i++) 
		cin >> info[i].first >> info[i].second;
	cout << result(n) << "\n";
	return 0;
}
