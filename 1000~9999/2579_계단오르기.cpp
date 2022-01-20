#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int stairs[301];
int dp[301];

int find(int n) {
	if (n < 0) return 0;
	if (dp[n] == 0) 
		dp[n] = max(stairs[n] + stairs[n-1] + find(n - 3), stairs[n] + find(n - 2));
	return dp[n];
}

int main() {
	memset(dp, 0, sizeof(dp));
	int n;
	cin >> n;
	
	for (int i = 1; i <= n; i++)
		cin >> stairs[i];
	dp[1] = stairs[1];
	
	cout << find(n) << '\n';
	return 0;
}
