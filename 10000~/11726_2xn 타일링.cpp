#include <iostream>
#include <cstring>
using namespace std;
int cnt[1001];

int dp(int n) {
	if (cnt[n] == 0) cnt[n] = (dp(n - 1) + dp(n - 2)) % 10007;
	return cnt[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(cnt, 0, sizeof(cnt));
	int n;

	cnt[1] = 1; cnt[2] = 2;
	cin >> n;
	cout << dp(n) << '\n';
	return 0;
}
