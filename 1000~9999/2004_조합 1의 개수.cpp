#include <iostream>
using namespace std;
long long two = 0, five = 0;

void count(long long end, bool plus) {
	for (long long i = 2; i <= end; i *= 2) (plus) ? two += (end / i) : two -= (end / i);
	for (long long i = 5; i <= end; i *= 5) (plus) ? five += (end / i) : five -= (end / i);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	long long n, m;
	
	cin >> n >> m;
	
	count(n, true);
	count(m, false);
	count(n - m, false);

	(two > five) ? cout << five << '\n' : cout << two << '\n';
	return 0;
}
