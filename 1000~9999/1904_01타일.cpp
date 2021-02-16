#include <iostream>
using namespace std;
int fibo[1000001];

int calc(int n) {
	fibo[1] = 1; fibo[2] = 2;
	for (int i = 3; i <= n; i++)
		fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 15746;
	return fibo[n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	cout << calc(n) << '\n';
	return 0;
}
