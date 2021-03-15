#include <iostream>
#include <cstring>
using namespace std;
int list[1000];

void dynamic(int n) {
	int dp[1000], ans = 0;
	for (int i = 0; i < n; i++) {
		dp[i] = 1;
		for (int j = i - 1; j >= 0; j--) {
			if (list[j] < list[i] && dp[j] >= dp[i])
				dp[i] = dp[j] + 1;
		}
		if (ans < dp[i]) ans = dp[i];
	}
	cout << ans << "\n";
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> list[i];
	dynamic(n);
	return 0;
}
