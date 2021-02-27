#include <iostream>
using namespace std;
int dp[10001], coin[100];

int calculate(int num, int money) {
	int tmp;
	dp[0] = 1;
	for (int i = 0; i < num; i++) {
		tmp = 0;
		for (int j = 1; j <= money; j++) {
			if (j%coin[i] == 0) tmp = coin[i];
			if (tmp > 0) dp[j] += dp[j - tmp];
		}
	}
	return dp[money];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int num, money;

	cin >> num >> money;
	for (int i = 0; i < num; i++)
		cin >> coin[i];
	cout << calculate(num, money) << "\n";
	return 0;
}
