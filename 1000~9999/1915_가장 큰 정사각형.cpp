#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;
int board[1001][1001];

void dynamic(int n, int m) {
	int dp[1001][1001];
	int ans = 0;

	memset(dp, 0, sizeof(dp));
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (board[i][j] == 1)
				dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
			ans = max(ans, dp[i][j]);
		}
	}
	cout << ans*ans << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	string tmp;

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		tmp.clear();
		cin >> tmp;
		for (int j = 0; j < m; j++)
			board[i][j + 1] = tmp[j] - '0';
	}
	dynamic(n, m);
	return 0;
}
