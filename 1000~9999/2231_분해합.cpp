#include <iostream>
using namespace std;

int main() {
	int num, sum = 0, tmp1, tmp2;
	bool flag = false;

	cin >> num;
	for (int i = num / 10; i < num; i++) {
		tmp1 = tmp2 = i;
		while (tmp1 != 0) {
			sum += tmp1;
			tmp1 = tmp2 % 10;
			tmp2 /= 10;
		}
		if (sum == num) {
			cout << i << '\n';
			flag = true;
			break;
		}
		sum = 0;
	}
	if (!flag)
		cout << 0 << '\n';

	return 0;
}
