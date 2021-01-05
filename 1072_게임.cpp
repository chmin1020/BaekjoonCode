#include <iostream>
using namespace std;

int main() {
	long long x, y, z;
	long long cnt = 0;

	cin >> x >> y;
	z = (y*100) / x;

	if (z == 99 || (x == y))
		cnt = -1;
	else {
		cnt = (x*(z + 1) - 100 * y) / (99 - z);
		if ((x*(z + 1) - 100 * y) % (99 - z) != 0)
			cnt++;
	}
	cout << cnt << "\n";
	return 0;
}
