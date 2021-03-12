#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, map[3];
	pair<int, int> dp[2][3];

	cin >> n >> map[0] >> map[1] >> map[2];
	for (int i = 0; i < 3; i++)
		dp[0][i].first = dp[0][i].second = map[i];
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 3; j++) 
			cin >> map[j];
	
		dp[1][0].first = max(dp[0][0].first, dp[0][1].first) + map[0];
		dp[1][1].first = max(max(dp[0][0].first, dp[0][1].first), dp[0][2].first) + map[1];
		dp[1][2].first = max(dp[0][1].first, dp[0][2].first) + map[2];
		dp[1][0].second = min(dp[0][0].second, dp[0][1].second) + map[0];
		dp[1][1].second = min(min(dp[0][0].second, dp[0][1].second), dp[0][2].second) + map[1];
		dp[1][2].second = min(dp[0][1].second, dp[0][2].second) + map[2];

		for (int j = 0; j < 3; j++)
			dp[0][j] = dp[1][j];
	}
	cout << max(max(dp[0][0].first, dp[0][1].first), dp[0][2].first) << " " << min(min(dp[0][0].second, dp[0][1].second), dp[0][2].second) << "\n";
	return 0;
}
