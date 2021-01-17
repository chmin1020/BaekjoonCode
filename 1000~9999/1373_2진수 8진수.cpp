#include <iostream>
#include <string>
using namespace std;

int main() {
	string two;
	string binary[8] = { "000","001","010","011","100","101","110","111" };

	cin >> two;

	if (two.size() % 3 == 1)
		two = "00" + two;
	else if (two.size() % 3 == 2)
		two = '0' + two;

	for (int i = 0; i + 2 < two.size(); i += 3) {
		for (int j = 0; j < 8; j++) {
			if (binary[j] == two.substr(i, 3)) {
				cout << j;
				break;
			}
		}
	}
	putc('\n', stdout);

	return 0;
}
