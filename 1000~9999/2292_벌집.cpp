#include <iostream>
using namespace std;

int main() {
	int num, start;
	cin >> num;

	if (num == 1) cout << "1" << endl;
	else {
		int i = 1;
		start = 1;
		while (start + 6 * i < num)
			start += 6 * (i++);
		cout << i + 1 << endl;
	}

	return 0;
}
