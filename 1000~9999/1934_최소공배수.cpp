#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n, num1, num2, tp1,tp2, r;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> num1 >> num2;
		if (num1 < num2) swap(num1, num2);
		tp1 = num1; tp2 = num2;

		while (1) {
			r = tp1%tp2;
			if (r == 0) break;
			tp1 = tp2; tp2 = r;
		}
		cout << tp2*(num1 / tp2)*(num2 / tp2) << '\n';
	}
	return 0;
}
