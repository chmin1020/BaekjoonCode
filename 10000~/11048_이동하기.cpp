#include <iostream>
#include <algorithm>
using namespace std;
int maze[1001][1001], dp[1001][1001];

int result(int n, int m) {
	int tmp;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			tmp = max(dp[i - 1][j], dp[i][j - 1]);
			tmp = max(tmp, dp[i - 1][j - 1]);
			dp[i][j] = maze[i][j] + tmp;
		}
	}
	return dp[n][m];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;

	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			cin >> maze[i][j];
	cout << result(n, m) << "\n";
	return 0;
}
