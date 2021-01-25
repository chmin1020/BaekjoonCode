#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int ans[50001];

int result(int n) {
	for (int i = 1; i <= n; i++) {
		ans[i] = 5;
		for (int j = 1; j <= sqrt(i); j++)
			ans[i] = min(ans[i], 1 + ans[i - j*j]);
	}
	return ans[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	cout << result(n) << '\n';
	return 0;
}
