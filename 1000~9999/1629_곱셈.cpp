#include <iostream>
using namespace std;

long long power(int base, int expo, int divider) {
	if (expo == 0) return 1;
	if (expo == 1) return base;
	long long num = power(base, expo / 2, divider) % divider;
	return ((num*num)%divider *((expo % 2 == 0) ? 1 : base % divider)) % divider;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int a, b, c;
	cin >> a >> b >> c;
	cout << power(a, b, c) % c<< '\n';
	return 0;
}
