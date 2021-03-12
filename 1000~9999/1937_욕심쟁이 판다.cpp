#include <iostream>
#include <algorithm>
using namespace std;
int bForest[501][501], dp[501][501];
bool visited[501][501];
int ans = 0;

int dfs(int n, pair<int, int> pos) {
	if (dp[pos.first][pos.second] == 1) {
		visited[pos.first][pos.second] = true;

		if (pos.first > 1 && bForest[pos.first - 1][pos.second] > bForest[pos.first][pos.second] && !visited[pos.first - 1][pos.second])
			dp[pos.first][pos.second] = max(dp[pos.first][pos.second], dfs(n, make_pair(pos.first - 1, pos.second)) + 1);
		if (pos.first < n && bForest[pos.first + 1][pos.second] > bForest[pos.first][pos.second] && !visited[pos.first + 1][pos.second])
			dp[pos.first][pos.second] = max(dp[pos.first][pos.second], dfs(n, make_pair(pos.first + 1, pos.second)) + 1);
		if (pos.second > 1 && bForest[pos.first][pos.second - 1] > bForest[pos.first][pos.second] && !visited[pos.first][pos.second - 1])
			dp[pos.first][pos.second] = max(dp[pos.first][pos.second], dfs(n, make_pair(pos.first, pos.second - 1)) + 1);
		if (pos.second < n && bForest[pos.first][pos.second + 1] > bForest[pos.first][pos.second] && !visited[pos.first][pos.second + 1])
			dp[pos.first][pos.second] = max(dp[pos.first][pos.second], dfs(n, make_pair(pos.first, pos.second + 1)) + 1);

		visited[pos.first][pos.second] = false;
	}
	return dp[pos.first][pos.second];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> bForest[i][j];
			dp[i][j] = 1;
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			dfs(n, make_pair(i, j));
			ans = max(ans, dp[i][j]);		
		}
	}
	cout << ans << "\n";
	return 0;
}
