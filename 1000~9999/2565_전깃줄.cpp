#include <iostream>
#include <algorithm>
using namespace std;
pair<int, int> lines[100];
int dp[100];

int LCS(int n) {
	int ans = 0;	
	fill_n(dp, n, 1);
	for (int i = 0; i < n; i++) {
		for (int j = i - 1; j >= 0; j--)
			if (lines[i].second > lines[j].second)
				dp[i] = max(dp[i], dp[j] + 1);
		ans = max(dp[i], ans);
	}
	return ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> lines[i].first >> lines[i].second;
	sort(lines, lines + n);
	cout << n - LCS(n) << "\n";
	return 0;
}
