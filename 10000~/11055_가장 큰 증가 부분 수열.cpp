#include <iostream>
using namespace std;
int seq[1000], dp[1000];

int result(int n) {
	int ans = seq[0];
	for (int i = 0; i < n; i++) {
		dp[i] = seq[i];
		for (int j = i - 1; j >= 0; j--)
			if (seq[i] > seq[j] && dp[i] < seq[i] + dp[j])
				dp[i] = seq[i] + dp[j];
		if (dp[i] > ans) ans = dp[i];
	}
	return ans;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> seq[i];
	cout << result(n) << "\n";
	return 0;
}
