#include <iostream>
using namespace std;

int main() {
	int ip[5];

	for (int i = 0; i < 5; i++)
		cin >> ip[i];

	for (int i = 0; i < 4; i++) {
		int tmp = ip[i + 1];
		for (int j = i; j >= 0; j--) {
			if (ip[j] > tmp) {
				ip[j + 1] = ip[j];
				ip[j] = tmp;
			}
			else {
				ip[j + 1] = tmp;
				break;
			}
		}
	}
	
	int tmp = ip[2];
	int cnt = 0;
	while (1) {
		for (int i = 0; i < 5; i++) {
			if (tmp%ip[i] == 0) cnt++;
			if (cnt == 3) break;
		}
		if (cnt == 3) {
			cout << tmp << endl;
			break;
		}
		cnt = 0;
		tmp++;
	}

	return 0;
}
