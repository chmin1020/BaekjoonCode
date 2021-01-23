#include <iostream>
#include <cstring>
using namespace std;
int cnts[1001];

int dp(int num) {
	if (cnts[num] == 0) cnts[num] = (2 * dp(num - 2) + dp(num - 1)) % 10007;
	return cnts[num];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	memset(cnts, 0, sizeof(cnts));
	cnts[1] = 1; cnts[2] = 3;
	cout << dp(n) << '\n';
	return 0;
}
