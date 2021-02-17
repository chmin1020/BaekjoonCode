#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int wine[10001];
int dp[10001];

int find(int n) {
	if (n < 0) return 0;
	if (dp[n] == 0) {
		dp[n] = max(wine[n] + wine[n - 1] + find(n - 3), wine[n] + find(n - 2));
		if (dp[n] < wine[n-1]+wine[n-2]+find(n-4)) dp[n] = wine[n - 1] + wine[n - 2] + find(n - 4);
	}
	return dp[n];
}

int main() {
	memset(dp, 0, sizeof(dp));
	int n;
	cin >> n;
	
	for (int i = 1; i <= n; i++)
		cin >> wine[i];
	dp[1] = wine[1];
	cout << find(n) << '\n';
	return 0;
}
