#include <iostream>
using namespace std;

int main() {
	int twoNum[2];
	int tmp = 0, sum = 0, i;

	cin >> twoNum[0] >> twoNum[1];

	for (i = 0;; i++) {
		tmp += i;
		if (tmp >= twoNum[0]) 
			break;
	}

	if (tmp > twoNum[1]) {

		sum += i * (twoNum[1] - twoNum[0] + 1);
	}
	else {
		sum += i * (tmp - twoNum[0] + 1);
		for (tmp; tmp < twoNum[1];) {
			i++;
			for (int j = 0; j < i; j++) {
				sum += i;
				tmp++;

				if (tmp >= twoNum[1])
					break;
			}
		}
	}

	cout << sum << endl;

	return 0;
}
