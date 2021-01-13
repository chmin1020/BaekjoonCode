#include <iostream>
#include <string>
using namespace std;
const int POWER = 31, MOD = 1234567891;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string str;
	int n;
	long long hash = 0, pow = 1;
	cin >> n;
	cin >> str;

	for (int i = 0; i < n; i++) {
		hash += ((str[i] - 'a' + 1)*pow);
		pow = (pow*POWER) % MOD;
		hash %= MOD;
	}
	cout << hash << '\n';
	return 0;
}
